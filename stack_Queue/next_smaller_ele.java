import java.util.Stack;

public class next_smaller_ele {
    public static int[] smaller(int []arr){
        int  n = arr.length;
       Stack<Integer> st = new Stack<>();
       int ans[] = new int[n];
       
       for(int i = 0 ; i< n ; i++){
           while(!st.isEmpty() && st.peek() > arr[i]){
               st.pop();
           }
           if(st.isEmpty()){
               ans[i] = -1;
               st.push(arr[i]);
           }else{
               ans[i] = st.peek();
               st.push(arr[i]);
           }
       }
       return ans;
    }
	public static void main(String[] args) {
		int ar[] = {4,5,2,10 , 8};
		int res[] = smaller(ar);
		for(int i = 0; i < ar.length ; i++){
		   System.out.print(res[i] + " ");
		}
	}

    
}
