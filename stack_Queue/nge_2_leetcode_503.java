import java.util.Stack;

public class nge_2_leetcode_503 {
    public static int [] nge_2(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int nge[] = new int[n];
        for(int i = 2*n -1 ; i >=0 ; i--){
            while(!st.isEmpty() && st.peek() <= arr[i%n]){
                st.pop();
            }
            if(i < n){
                nge[i]= st.isEmpty() ? -1 : st.peek();
            }
            st.push(arr[i %n]);
        }
        return nge;
    }
    public static void main(String[] args) {
        int ar[] = {2, 10 ,12 , 1, 11};
        int ans[] = nge_2(ar);
        for(int i = 0 ; i < ar.length ; i++){
            System.out.print(ans[i] + " ");
        }
    }
    
}
