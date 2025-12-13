import java.util.Scanner;

// Node class representing each Patient
class Patient {
    int id;
    String name;
    int age;
    String disease;
    Patient next; // pointer to next patient in queue

    public Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.next = null;
    }
}

// Queue implementation using Linked List
class PatientQueue {
    Patient front, rear;

    public PatientQueue() {
        front = rear = null;
    }

    // Enqueue operation: Add new patient to end of queue
    public void enqueue(Patient newPatient) {
        if (rear == null) {
            front = rear = newPatient;
            System.out.println("✅ Patient registered successfully!");
            return;
        }
        rear.next = newPatient;
        rear = newPatient;
        System.out.println("✅ Patient registered successfully!");
    }

    // Dequeue operation: Remove front patient (treated)
    public void dequeue() {
        if (front == null) {
            System.out.println("⚠️ No patients in queue!");
            return;
        }

        System.out.println("🩺 Treating patient: " + front.name + " (ID: " + front.id + ")");
        front = front.next;

        if (front == null)
            rear = null;
    }

    // Display all patients
    public void display() {
        if (front == null) {
            System.out.println("⚠️ No patients currently waiting.");
            return;
        }

        System.out.println("\n--- Current Patients in Queue ---");
        Patient temp = front;
        while (temp != null) {
            System.out.println("ID: " + temp.id +
                               ", Name: " + temp.name +
                               ", Age: " + temp.age +
                               ", Disease: " + temp.disease);
            temp = temp.next;
        }
        System.out.println("---------------------------------\n");
    }

    // 🔍 Search Patient by ID
    public void searchById(int id) {
        if (front == null) {
            System.out.println("⚠️ Queue is empty!");
            return;
        }
        Patient temp = front;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println("✅ Patient found:");
                System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Age: " + temp.age + ", Disease: " + temp.disease);
                return;
            }
            temp = temp.next;
        }
        System.out.println("❌ Patient with ID " + id + " not found!");
    }

    // 🔍 Search Patient by Name
    public void searchByName(String name) {
        if (front == null) {
            System.out.println("⚠️ Queue is empty!");
            return;
        }
        Patient temp = front;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("✅ Patient found:");
                System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Age: " + temp.age + ", Disease: " + temp.disease);
                return;
            }
            temp = temp.next;
        }
        System.out.println("❌ No patient found with name: " + name);
    }

    // 🔢 Count total patients
    public void countPatients() {
        int count = 0;
        Patient temp = front;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("🧾 Total patients waiting: " + count);
    }

    // ⚕️ Show next patient to treat (peek)
    public void peekNext() {
        if (front == null) {
            System.out.println("⚠️ No patients waiting!");
            return;
        }
        System.out.println("👨‍⚕️ Next patient to treat: " + front.name + " (ID: " + front.id + ")");
    }
}

// Main class
public class hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientQueue pq = new PatientQueue();

        int choice;
        int id = 1;

        do {
            System.out.println("\n🏥 HOSPITAL PATIENT MANAGEMENT SYSTEM");
            System.out.println("=======================================");
            System.out.println("1. Register New Patient");
            System.out.println("2. Treat (Remove) Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Search Patient by ID");
            System.out.println("5. Search Patient by Name");
            System.out.println("6. Show Next Patient to Treat");
            System.out.println("7. Count Total Patients");
            System.out.println("8. Exit");
            System.out.println("=======================================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter disease: ");
                    String disease = sc.nextLine();

                    Patient newPatient = new Patient(id++, name, age, disease);
                    pq.enqueue(newPatient);
                    break;

                case 2:
                    pq.dequeue();
                    break;

                case 3:
                    pq.display();
                    break;

                case 4:
                    System.out.print("Enter patient ID to search: ");
                    int searchId = sc.nextInt();
                    pq.searchById(searchId);
                    break;

                case 5:
                    System.out.print("Enter patient name to search: ");
                    String searchName = sc.nextLine();
                    pq.searchByName(searchName);
                    break;

                case 6:
                    pq.peekNext();
                    break;

                case 7:
                    pq.countPatients();
                    break;

                case 8:
                    System.out.println("👋 Exiting system... Stay Healthy!");
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }

        } while (choice != 8);

        sc.close();
    }
}
