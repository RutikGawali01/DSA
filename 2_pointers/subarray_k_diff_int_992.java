
import java.util.HashMap;
import java.util.HashSet;

public class subarray_k_diff_int_992 {

    // brute force -> TC = O(n^2);
    public static int diff_int(int[] arr , int k ){
        int n = arr.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            HashSet<Integer> freq = new HashSet<>();
            for(int j = i ; j<n ; j++){
                freq.add(arr[j]);
                if(freq.size() == k){
                    count++;
                }
                if(freq.size() > k){
                    break;
                }
            }
        }
        return count;
    }

    //Optimal solutions
    // helper method
    public static int helper_subarrays_With_K_Distinct(int [] arr , int k ){
        int n = arr.length;
        int right = 0;
        int left = 0;
        int count = 0;
        HashMap<Integer , Integer> mpp = new HashMap<>();
        while(right < n ){
            mpp.put(arr[right], mpp.getOrDefault(arr[right], 0)+1);
            while(mpp.size() > k){
                mpp.put(arr[left], mpp.getOrDefault(arr[left], 0)-1);
                if(mpp.getOrDefault(arr[left], 0) == 0){
                    mpp.remove(arr[left]);
                }
                left++;
            }
            count+= (right - left +1);
            right++;
        }
        return count;
    }
    
    public static int subarrays_With_K_Distinct(int [] arr , int k ){
        return helper_subarrays_With_K_Distinct(arr, k) - helper_subarrays_With_K_Distinct(arr, k-1);
    }



    public static void main(String[] args) {
        int [] arr = {1,2,1,2,3};
        int k = 2;
        System.out.println(diff_int(arr, k));

        System.out.println(subarrays_With_K_Distinct(arr, k));
    }
}
