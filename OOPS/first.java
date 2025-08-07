



class  Pen{
    String color; 
    String type;

    public void write(){
        System.out.println("writting");
    }
    public void printColor(){
        System.out.println(this.color);
    }
}

class Student{
    String name;
    int age;
    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }
    //non - parameterized constructor
    public Student() {
        System.out.println("constructor called");
        
    }

    //parametirized constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //copy constructor 

    Student(Student s2){
        this.name = s2.name;
        this.age = s2.age;
    }

    
    
}
public class first {
    public static void main(String[] args) {
        
        Pen p1 = new Pen();
        p1.color = "blue";
        p1.type = "gel";
        p1.write();

        Pen p2 = new Pen();
        p2.color = "black";
        p2.printColor();


        Student s1 = new Student("Rutik" , 20);
        s1.printInfo();
        
    }
    
}
