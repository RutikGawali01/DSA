 
import java.util.LinkedList;
import java.util.Queue;
public class stack_using_queue {
    static class stack{
        static Queue<Integer> q = new LinkedList<>();
        public static void push(int data){
            int size = q.size();
            q.add(data);
            for(int i = 1 ; i <= size ; i++){
                q.add(q.remove());
            }

        }
        public static int pop(){
            return q.remove();
        }
        public static int peek(){
            return q.peek();
        }
        public static boolean isEmpty(){
            return q.isEmpty();
        }

    }
    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
            
        }
    }
}
