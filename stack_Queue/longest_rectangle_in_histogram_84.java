
import java.util.Stack;

public class longest_rectangle_in_histogram_84 {

    public static int longest_rect_area(int [] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int maxArea = 0;
        for(int i =0 ; i< n ; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int ele = st.peek();
                st.pop();
                int nse= i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea , arr[ele]*(nse-pse-1));

            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse = n;
            int ele = st.peek();
            st.pop();
            int pse = st.isEmpty() ? -1: st.peek();
            maxArea = Math.max(maxArea , arr[ele]*(nse-pse-1));
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        int ans = longest_rect_area(arr);
        System.out.println(ans);
    }
}
