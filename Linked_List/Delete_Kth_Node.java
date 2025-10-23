public class Delete_Kth_Node{

    public static class Node {
        public int data;      
        public Node next;    
        public Node prev;  
       
        public Node(int data1, Node next1, Node back1) {
            data = data1;
            next = next1;
            prev = back1;
        }

        public Node(int data1) {
            data = data1;
            next = null;
            prev = null;
        }
    }

    private static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null; 
        }
        
        Node Newhead = head.next;
        
        Newhead.prev = null; 
        head.next = null; 
        return Newhead;
    }

    private static Node deleteTail(Node tail,Node head) {
        if (head == null || head.next == null) {
            return null; 
        }    
        Node newtail = tail.prev;
        
        newtail.next = null;
        tail.prev = null;
        
        return head;
    }

    public static  Node delPos(Node head, int k) {

        if(head == null)return null;

        int size = 1;
        Node current = head;// for iteration
        Node kthNode = null; // node to be deleted
        Node tail = head;// used in deleteTail with O(1) TC.


        while(current != null){
        
            if(size == k){
                kthNode = current;
            }
            tail = tail.next;
            current = current.next;
            size++;
        }

        Node front = kthNode.next;
        Node back = kthNode.prev;


        if(front == null && back == null){
            return null;
        }else if(back == null){
            return deleteHead(head); // delete head
        }else if( front == null){
            return deleteTail(kthNode,head); // delete tail
        }

        // middle node
        back.next = front;
        front.prev = back;
        kthNode.next = null;
        kthNode.prev = null;

        return head;
    }

    private static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head; 

        for (int i = 1; i < arr.length; i++) {
            
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp; 
            prev = temp; 
        }
        return head; 
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " "); 
            head = head.next; 
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8 , 3};
        Node head = convertArr2DLL(arr); 

        head = delPos(head, 3);
        print(head);

    }
}


// This is causing TLE
/* public Node delPos(Node head, int x) {
        if( x == 1){
            head.next.prev = null;
            return head.next;
        }
        
        Node temp = head;
        for(int i = 1 ; i< x-1 ; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        if(temp.next != null){
            temp.next.prev = temp;
        }
       
        
        return head;
    }*/