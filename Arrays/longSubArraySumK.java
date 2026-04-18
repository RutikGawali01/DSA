
import java.util.HashMap;


public  class  longSubArraySumK{
    //brute force-- using 2- 3 nested loops too much time complexity 


    // optimal -- find sum upto each index and store it in map with its iindex 
    //  find rem  if rem present in map means subarray with gien sum k exists so calculate length 
    // continue  this till the end of an Array
    public static int longestSubArraySumK(int[] arr , int k ){
        int len = 0;
        HashMap<Integer , Integer> presum = new HashMap();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            int rem = sum - k;
            if(presum.containsKey(rem)){
                len = Math.max(len,(i-presum.get(rem)) );
                
            }
            // we wantes longest subarray sp if we got sum previously we did not updated i - bcz if updated that sum pair = it will reduce pair
            
            if(!presum.containsKey(sum)){
                presum.put(sum, i);
            
            }
        }
        return  len;


    }
    public static void main(String[] args) {

        int[] arr = {2 , 4, 8 , 1 , 1, 1, 1};
        int k = 4;

        System.out.println(longestSubArraySumK(arr, k));
    }
}