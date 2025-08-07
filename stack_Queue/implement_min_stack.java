import java.util.Stack;
public class implement_min_stack {
    static class pair{
        int x;
        int y;

        public pair(int x , int y) {
            this.x = x;
            this.y = y;
        }
        
    }

    static class stack{
        static Stack <pair> st; /*
         - Being static means:
            - It belongs to the class itself, not any instance.
            - All instances of the stack class will share this same st.*/

        public stack() {
        st = new Stack < > ();
        }/*  - It initializes the st stack object as a new, empty Stack of pair.*/
        /* 
        you want each stack object to manage its own data independently, remove the static keyword:
        that's why we created this constructor;
         */


/* instead of all above lines  static Stack <pair> st = new Stack < > (); this will also work bcz st is static   */
        public static void push(int val){
            int min;
            if(st.isEmpty()){
                min = val;
            }else{
                min = Math.min(val , st.peek().y);
            }
            st.push(new pair(val , min));  /* bcz of new it will create fresh another object of pair  */
        }
        public static void pop(){
            st.pop();
        }
        public static int top(){
            return st.peek().x;
        }
        public static int getmin(){
            return st.peek().y;
        }
        public static boolean isEmpty(){
            return st.isEmpty();
        }
    }
    public static void main(String[] args) {
        stack s = new stack();
        s.push(12);
        s.push(15);
        s.push(10);

        while(!s.isEmpty()){
            System.out.println("top :" + s.top());
            System.out.println("min : "+ s.getmin());

            s.pop();

        }
    }
    
}
