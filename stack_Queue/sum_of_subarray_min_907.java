import java.util.Stack;

public class sum_of_subarray_min_907 {
// brute force solution
   /* public static int subarray_min(int[] arr){
        int  n = arr.length;
        int sum =0;
        for(int i = 0; i< n ; i++){
            int min  = arr[i];
            for(int j = i; j < n ; j++){
                min = Math.min(min , arr[j]);
                sum += min;
            }
        }
        return sum;

    }*/
 
 // optimal


 public static int [] findNSE(int [] arr){
    Stack<Integer> st = new Stack<>();
    int n = arr.length;
    int[] nse = new int[n];
    for(int i =  n -1 ; i>= 0 ; i--){
        while(!st.isEmpty() && (arr[st.peek()] > arr[i])){
            st.pop();
        }
        nse[i] = st.isEmpty() ? n : st.peek();
        st.push(i);
    }
    return nse;
 }

 public static int[] findPSEE(int [] arr){
    int n = arr.length;
    Stack<Integer> st = new Stack<>();
    int[] psee = new int[n];
    for(int i = 0; i< n ; i++){
        while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
            st.pop();
        }
        psee[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i);
    }
    return psee;
 }

 
 public static  int subarray_min(int [] arr){
    int nse[] = findNSE(arr);
    int psee[] = findPSEE(arr);
    int total = 0;
    int mod = (int)(1e9 + 7);
    int n = arr.length;

    for(int i  = 0 ;  i< n  ; i++){
        int left = i - psee[i];
        int right = nse[i] - i;

        total = (int)(total + (left * right * 1l * arr[i]) % mod) % mod ;

    }
    return total;
 }

    public static void main(String[] args) {
    // int arr[] = {3,1 ,2,4};
    int arr[] = { 71,55,82,55};
    System.out.println(subarray_min(arr));
   } 
}
