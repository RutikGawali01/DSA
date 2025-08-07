import java.util.Stack;
public class sum_of_subarray_ranges_2104 {
    //brute force of tim ecomplexity = O(n^2);
    public static int subarray_ranges(int[] arr){
        int n = arr.length;
        int total = 0;

        for(int i = 0; i< n ; i++){
            int mini = arr[i];
            int maxi = arr[i];
            for(int j= i ; j < n ; j++){
                mini = Math.min(mini , arr[j]);
                maxi = Math.max(maxi , arr[j]);
                total += (maxi - mini); 
            }
            
        }
        return total;
    }
  
    
    
    public static int[] findNSE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && (arr[st.peek()] > arr[i])) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
    
    public static int[] findPSEE(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] psee = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }
    
    
    public static long subarray_min(int[] arr) { 
        int[] pse = findPSEE(arr);
        int[] nse = findNSE(arr);
        int n = arr.length;
        long total = 0;
        int mod = (int) (1e9 + 7);
        
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            long arrVal = arr[i] % mod;
            if (arrVal < 0) arrVal += mod; // Handle negative values
            
            // Calculate contribution with proper modular arithmetic
            long contrib = ((left % mod) * (right % mod)) % mod;
            contrib = (contrib * arrVal) % mod;
            
            total = (total + contrib) % mod;
        }
        return total;
    }
    
    public static int[] findNGE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nge = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && (arr[st.peek()] < arr[i])) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }
    
    public static int[] findPGE(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] pge = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
    
    public static long subarray_max(int[] arr) {
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);
        long total = 0;
        int mod = (int) (1e9 + 7);
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            long arrVal = arr[i] % mod;
            if (arrVal < 0) arrVal += mod; // Handle negative values
            
            // Calculate contribution with proper modular arithmetic
            long contrib = ((left % mod) * (right % mod)) % mod;
            contrib = (contrib * arrVal) % mod;
            
            total = (total + contrib) % mod;
        }
        return total;
    }
    
    public static long subArrayRanges(int[] nums) {
        long max = subarray_max(nums);
        long min = subarray_min(nums);
        int mod = (int) (1e9 + 7);
        
        // Handle the subtraction properly

        long result = (max - min) % mod;
        if (result < 0) result += mod;
        
        return result;
    }



    public static void main(String[] args) {
        int [] arr = {3,1,2,4};
        // System.out.println(subarray_ranges(arr));

        System.out.println(subarray_ranges(arr));


    }
}
