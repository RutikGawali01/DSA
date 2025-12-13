// library management system 

// all classes in  this project
// Book --> all details of book  
// bookNOde ---> nodes of BST
//member -- members details
// library --> for all info related libraary 


// add , search and display books --> Using BSt bcz of log(n) TC
//add and display members  --> Array bcz we can access with member id
// borrow ans return books --> linked list bcz we have referenced to previous book 
// trascation --> stack bcz LIFO 
// waiting list --> Queue for FIFO







import java.util.*;

    class Book {
        int id;
        String title;
        String author;
        boolean isIssued;
        Queue<Member> waitingList; 

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
            this.waitingList = new LinkedList<>();
        }

        @Override
        public String toString() {
            return "[" + id + "] \"" + title + "\" by " + author + (isIssued ? " (Issued)" : " (Available)");
        }
    }

class Member {
    int memberId;
    String name;
    LinkedList<Book> borrowedBooks; 

    Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new LinkedList<>();
    }

    void borrow(Book book) {
        borrowedBooks.add(book);
        book.isIssued = true;
    }

    boolean returnBook(Book book) {
        boolean removed = borrowedBooks.remove(book);
        if (removed) book.isIssued = false;
        return removed;
    }

    @Override
    public String toString() {
        return memberId + ": " + name;
    }
}

class Transaction {
    enum Type { ISSUE, RETURN, ADD_BOOK, REMOVE_BOOK }
    Type type;
    Book book;
    Member member;

    Transaction(Type type, Book book, Member member) {
        this.type = type;
        this.book = book;
        this.member = member;
    }

    @Override
    public String toString() {
        switch (type) {
            case ISSUE: return "ISSUE - " + book.title + " to " + member.name;
            case RETURN: return "RETURN - " + book.title + " from " + member.name;
            case ADD_BOOK: return "ADD_BOOK - " + book.title;
            case REMOVE_BOOK: return "REMOVE_BOOK - " + book.title;
            default: return "UNKNOWN TRANSACTION";
        }
    }
}


// used to store and search book 
class BookBST {
    class Node {
        Book book;
        Node left, right;
        Node(Book book) { this.book = book; }
    }
    private Node root;

    // add new book in BST
    void insert(Book book) {
        root = insertRec(root, book);
    }

    // recursive insertion 
    private Node insertRec(Node node, Book book) {
        if (node == null) return new Node(book);
        if (book.id < node.book.id) node.left = insertRec(node.left, book);
        else if (book.id > node.book.id) node.right = insertRec(node.right, book);
        return node;
    }

    Book search(int id) {
        Node curr = root;
        while (curr != null) {
            if (id == curr.book.id) return curr.book;
            curr = (id < curr.book.id) ? curr.left : curr.right;
        }
        return null;
    }

    void inorderPrint() { inorder(root); }

    // display all books
    private void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.book);
        inorder(node.right);
    }

    void remove(int id) { root = removeRec(root, id); }

    private Node removeRec(Node node, int id) {
        if (node == null) return null;
        if (id < node.book.id) node.left = removeRec(node.left, id);
        else if (id > node.book.id) node.right = removeRec(node.right, id);
        else {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            Node successor = minNode(node.right);
            node.book = successor.book;
            node.right = removeRec(node.right, successor.book.id);
        }
        return node;
    }

    private Node minNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }
}


class CategoryNode {
    String name;
    List<CategoryNode> children = new ArrayList<>();
    CategoryNode(String name) { this.name = name; }
}

class CategoryTree {
    CategoryNode root;
    CategoryTree(String rootName) { root = new CategoryNode(rootName); }

    void printTree() { printRec(root, 0); }

    private void printRec(CategoryNode node, int depth) {
        if (node == null) return;
        System.out.println("  ".repeat(depth) + "- " + node.name);
        for (CategoryNode child : node.children) printRec(child, depth + 1);
    }
}


class Library {
    String[] categories; 
    BookBST bookBST;
    CategoryTree categoryTree;
    Map<Integer, Member> members;
    Stack<Transaction> undoStack;
    int nextBookId = 1001;
    int nextMemberId = 5001;

    Library(String[] categories) {
        this.categories = categories;
        this.bookBST = new BookBST();
        this.categoryTree = new CategoryTree("Library");
        this.members = new HashMap<>();
        this.undoStack = new Stack<>();
        buildCategoryTree();
    }

    void buildCategoryTree() {
        for (String cat : categories) {
            CategoryNode child = new CategoryNode(cat);
            categoryTree.root.children.add(child);
            child.children.add(new CategoryNode(cat + " - Shelf A"));
            child.children.add(new CategoryNode(cat + " - Shelf B"));
        }
    }

    Book addBook(String title, String author) {
        Book book = new Book(nextBookId++, title, author);
        bookBST.insert(book);
        undoStack.push(new Transaction(Transaction.Type.ADD_BOOK, book, null));
        System.out.println("Book added: " + book);
        return book;
    }

    void removeBook(int id) {
        Book b = bookBST.search(id);
        if (b == null) { System.out.println("Book not found."); return; }
        if (b.isIssued) { System.out.println("Book is issued and cannot be removed."); return; }
        bookBST.remove(id);
        undoStack.push(new Transaction(Transaction.Type.REMOVE_BOOK, b, null));
        System.out.println("Book removed: " + b);
    }

    Member addMember(String name) {
        Member m = new Member(nextMemberId++, name);
        members.put(m.memberId, m);
        System.out.println("Member added: " + m);
        return m;
    }

    void issueBook(int bookId, int memberId) {
        Book b = bookBST.search(bookId);
        Member m = members.get(memberId);
        if (b == null || m == null) { System.out.println("Invalid book or member."); return; }

        if (!b.isIssued) {
            m.borrow(b);
            undoStack.push(new Transaction(Transaction.Type.ISSUE, b, m));
            System.out.println("Issued " + b.title + " to " + m.name);
        } else {
            b.waitingList.offer(m);
            System.out.println(m.name + " added to waiting list for " + b.title);
        }
    }

    void returnBook(int bookId, int memberId) {
        Book b = bookBST.search(bookId);
        Member m = members.get(memberId);
        if (b == null || m == null) { System.out.println("Invalid book or member."); return; }

        if (m.returnBook(b)) {
            undoStack.push(new Transaction(Transaction.Type.RETURN, b, m));
            System.out.println(m.name + " returned " + b.title);

            if (!b.waitingList.isEmpty()) {
                Member next = b.waitingList.poll();
                next.borrow(b);
                undoStack.push(new Transaction(Transaction.Type.ISSUE, b, next));
                System.out.println("Auto-issued to next member in queue: " + next.name);
            }
        } else System.out.println(m.name + " does not have this book.");
    }

    void displayAllBooks() { bookBST.inorderPrint(); }
    void displayCategoryTree() { categoryTree.printTree(); }

    void displayMembers() {
        System.out.println("Members and their borrowed books:");
        for (Member m : members.values()) {
            System.out.print(m + " -> ");
            if (m.borrowedBooks.isEmpty()) System.out.println("No books borrowed");
            else for (Book b : m.borrowedBooks) System.out.print(b.title + ", ");
            System.out.println();
        }
    }

    void displayWaitingList(int bookId) {
        Book b = bookBST.search(bookId);
        if (b == null) { System.out.println("Book not found."); return; }
        if (b.waitingList.isEmpty()) { System.out.println("No waiting members."); return; }
        System.out.println("Waiting list for " + b.title + ":");
        for (Member m : b.waitingList) System.out.println(" - " + m.name);
    }

    void seedData() {
        addBook("Data Structures", "A. Author");
        addBook("Operating Systems", "B. Author");
        addBook("Computer Networks", "C. Author");
        addMember("Alice");
        addMember("Bob");
        addMember("Charlie");
    }
}


public class libraryManagement {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] defaultCategories = {"Science", "Technology", "Fiction", "History", "Art"};
        Library lib = new Library(defaultCategories);
        lib.seedData();

        boolean exit = false;
        while (!exit) {
            printMenu();
            System.out.print("Enter option: ");
            int ch = readInt();
            System.out.println();

            switch (ch) {
                case 1 -> { // Add Book
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    lib.addBook(title, author);
                }
                case 2 -> { // Remove Book
                    System.out.print("Enter book ID: ");
                    lib.removeBook(readInt());
                }
                case 3 -> lib.displayAllBooks();
                case 4 -> { // Add Member
                    System.out.print("Enter member name: ");
                    lib.addMember(sc.nextLine());
                }
                case 5 -> { // Issue Book
                    System.out.print("Enter book ID: ");
                    int bid = readInt();
                    System.out.print("Enter member ID: ");
                    int mid = readInt();
                    lib.issueBook(bid, mid);
                }
                case 6 -> { // Return Book
                    System.out.print("Enter book ID: ");
                    int rb = readInt();
                    System.out.print("Enter member ID: ");
                    int rm = readInt();
                    lib.returnBook(rb, rm);
                }
                case 7 -> { // Search Book
                    System.out.print("Enter book ID to search: ");
                    Book found = lib.bookBST.search(readInt());
                    System.out.println(found != null ? "Found: " + found : "Not found.");
                }
                case 8 -> lib.displayCategoryTree(); // Tree demo
                case 9 -> lib.displayMembers(); // LinkedList demo
                case 10 -> { // Queue demo
                    System.out.print("Enter book ID to view waiting list: ");
                    lib.displayWaitingList(readInt());
                }
                case 0 -> {
                    System.out.println("Exiting system...");
                    exit = true;
                }
                default -> System.out.println("Invalid choice.");
            }
            System.out.println();
        }
    }

    static void printMenu() {
        System.out.println("  Library Management System  ");
        System.out.println("1.  Add Book");
        System.out.println("2.  Remove Book");
        System.out.println("3.  Display All Books (BST)");
        System.out.println("4.  Add Member");
        System.out.println("5.  Issue Book");
        System.out.println("6.  Return Book");
        System.out.println("7.  Search Book by ID");
        System.out.println("8.  Show Category Tree (Tree)");
        System.out.println("9.  Display Members (LinkedList)");
        System.out.println("10. Show Waiting List (Queue)");
        System.out.println("0.  Exit");
    }

    static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}


// output

// C:\Users\rutik\OneDrive\Desktop\Leetcode_solutions>javac libraryManagement.java

// C:\Users\rutik\OneDrive\Desktop\Leetcode_solutions>java libraryManagement
// Book added: [1001] "Data Structures" by A. Author (Available)
// Book added: [1002] "Operating Systems" by B. Author (Available)
// Book added: [1003] "Computer Networks" by C. Author (Available)
// Member added: 5001: Alice
// Member added: 5002: Bob
// Member added: 5003: Charlie
//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 1

// Enter book title: DSA 
// Enter author: Narasimha
// Book added: [1004] "DSA " by Narasimha (Available)

//   Library Management System  
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 2

// Enter book ID: 1002
// Book removed: [1002] "Operating Systems" by B. Author (Available)

//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 3

// [1001] "Data Structures" by A. Author (Available)
// [1003] "Computer Networks" by C. Author (Available)
// [1004] "DSA " by Narasimha (Available)

//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 4

// Enter member name: rutik
// Member added: 5004: rutik

//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 5

// Enter book ID: 1003
// Enter member ID: 5004
// Issued Computer Networks to rutik

//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 6

// Enter book ID: 5004
// Enter member ID: 5001
// Invalid book or member.

//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 6

// Enter book ID: 1003
// Enter member ID: 5004
// rutik returned Computer Networks

//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 7

// Enter book ID to search: 1003
// Found: [1003] "Computer Networks" by C. Author (Available)

//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 8

// - Library
//   - Science
//     - Science - Shelf A
//     - Science - Shelf B
//   - Technology
//     - Technology - Shelf A
//     - Technology - Shelf B
//   - Fiction
//     - Fiction - Shelf A
//     - Fiction - Shelf B
//   - History
//     - History - Shelf A
//     - History - Shelf B
//   - Art
//     - Art - Shelf A
//     - Art - Shelf B

//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 9

// Members and their borrowed books:
// 5001: Alice -> No books borrowed

// 5002: Bob -> No books borrowed

// 5003: Charlie -> No books borrowed

// 5004: rutik -> No books borrowed


//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 10

// Enter book ID to view waiting list: 1003
// No waiting members.

//   Library Management System
// 1.  Add Book
// 2.  Remove Book
// 3.  Display All Books (BST)
// 4.  Add Member
// 5.  Issue Book
// 6.  Return Book
// 7.  Search Book by ID
// 8.  Show Category Tree (Tree)
// 9.  Display Members (LinkedList)
// 10. Show Waiting List (Queue)
// 0.  Exit
// Enter option: 0

// Exiting system...
