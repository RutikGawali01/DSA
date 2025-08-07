import java.util.Stack;

public class min_stack_2 {
    static class stack{
        static Stack<Integer> s = new Stack<>();
        static int min = Integer.MAX_VALUE;
        public static void push(int val){
            if(s.isEmpty()){
                s.push(val);
                min = val;
            }else{
                if(val > min){
                    s.push(val);
                }else{
                    s.push(2*val - min);
                    min = val;
                }
            }
        }

        public static void pop(){
            if(s.isEmpty()){
                return;
            }
            int x = s.peek();
            s.pop();
            if(x < min){
                min = 2*min - x;
            }
        }

        public static int top(){
            if(s.isEmpty()){
                return -1;
            }
            int x = s.peek();
            if(min > x){
                return min;
            }else{
                return x;
            }
        }
        public static int getmin(){
            if(s.isEmpty()){
                return -1;
            }
            return min;
        }
        public static boolean isEmpty(){
            return s.isEmpty();
        }
    }
    public static void main(String[] args) {
        stack st = new stack();
        st.push(8);
        st.push(10);
        st.push(7);

        while(!st.isEmpty()){
            System.out.println(" top : "  + st.top());
            System.out.println("min : " + st.getmin());
            st.pop();
        }
    }
    
}
