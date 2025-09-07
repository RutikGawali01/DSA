
import java.util.Comparator;
import java.util.PriorityQueue;

public class basic{

    /*static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }*/
    public static void main(String[] args) {
        // priority queue for basic data type 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());// see the changes by removinng revrse order 
        pq.add(3);
        pq.add(6);
        pq.add(1);
        pq.add(9);

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }



        //Priority Queue for Objects 
       /*  PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("A", 4));//O(logn)
        pq.add(new Student("B", 11));
        pq.add(new Student("C", 1));               
        pq.add(new Student("D", 9));
        
        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
        }*/
    }
}