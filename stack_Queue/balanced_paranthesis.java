
import java.util.Stack;

public class balanced_paranthesis {
    public static boolean  balnced(String s){
        Stack<Character> st = new Stack<>();
        // instead of for loop use for each loop
        for(int i =0; i< s.length(); i++){
            if((s.charAt(i) == '(') || (s.charAt(i) == '{') ||( s.charAt(i) == '[')){
                st.push(s.charAt(i));
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char ch = st.peek();
                st.pop();
                if( (s.charAt(i) == ')' && ch == '(') || (s.charAt(i) == '}' && ch == '{') || (s.charAt(i) == ']' && ch == '[')){

                }else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String str = "()[{}]()]";
        System.out.println(balnced(str));
    }
    
}
