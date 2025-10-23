public class que2{
    //TLE for below solution
    //  public static  int longestSubsequence(int[] nums) {
    //     int length = 0;
    //     int n = nums.length;
    //     for(int i = 0 ; i<n ; i++){
    //         long xor = nums[i];
    //         int count = 1;
    //         for(int j = i+1 ; j<n ;j++){
    //             xor = xor^nums[j];
    //             count++;
    //         }
    //         if(xor!= 0){
    //             length = Math.max(length , count);
    //         }
            
    //     }
    //     return length;
    // }

     public static  int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalxor = 0 ; 
        for(int i = 0 ; i<n ;i++){
            totalxor = totalxor^nums[i];
        }
        if(totalxor != 0){
            return n;
        }

        int left = 0;
        int right = 0;
        int prefix = 0 ;
        int suffix = 0;

        while(left < n && prefix == 0){
            prefix = prefix^nums[left];
            left++;
        }
        while(right<n&& suffix == 0){
            suffix = suffix ^ nums[n-1-right];
            right++;
        }

        return n- Math.min(left , right);
    }
    public static void main(String[] args) {
        int [] arr = {2,3,4};
        System.out.println(longestSubsequence(arr));
    }
}