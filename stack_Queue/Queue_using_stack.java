import java.util.Stack;

public class Queue_using_stack {
    //stack should behave as queue
    /*     static class Queue{
            static Stack<Integer> s1 = new Stack<>();
            static Stack<Integer> s2 = new Stack<>();
            // add operatin take O(n) time
            public static void add(int data){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
                s1.push(data);
                while(!s2.isEmpty()){
                    s1.push(s2.pop());
                }
            }

            public static int remove(){
                return s1.pop();
            }
            public static int peek(){
                return s1.peek();
            }
            public static boolean isEmpty(){
                return s1.isEmpty();
            }


        }*/
    
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static void add(int data){
            s1.push(data);
        }

        public static int remove(){
            if(!s2.isEmpty()){
                return s2.pop();
            }
            else{
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public static int top(){
            if(!s2.isEmpty()){
                return s2.peek();
            }
            else{
                while(!s1.isEmpty()){
                    s2.push(s1.peek());
                }
            }
            return s2.peek();     
        }
        public static boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty();
        }

    }
        public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }    
}
