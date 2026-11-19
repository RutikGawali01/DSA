public class LC_4075_Longest_Resilient_Subarray_I {

    class Solution {
        // key idea -
// Identify longest subarray where all elements have same remainder and satisfy divisibility condition

        public int resilientSubarray(int[] nums, int k) {
            // Every element in a resilient subarray must have the same remainder when divided by k.
            int n = nums.length;

            //IMP -  After removing any one element, the sum of the remaining elements must be divisible by k.

            // int[] rem = new int[n];

            // for(int i = 0 ; i< n ; i++){
            //     rem[i] = nums[i] % k;
            // }

            // we are using formmaula - (L-1)*r % k == 0
            // instead of doing sum of all the ele mod k is  same as sum of all ele remainders mod k
            // so  for resilient sub-array all the ele remainders should be same -
            // so instead of doing sum  we  can do
            // L * rem - but we are removing one ele and  checking - -- so L-1 is used -

            //  that  is how this above formula is generated -


            int max = 1;
            int cnt = 1;
            int start = nums[0] % k;
            for(int i = 1 ; i < n ; i++){
                // remainder of each - ele
                int rem = nums[i] % k;
                if(start == rem ){
                    cnt++;
                    // (L-1)*r % k == 0 // cnt is same as len -
                    if(( (cnt-1)*rem) % k == 0 ){
                        max = Math.max(max , cnt);
                    }


                } else{
                    //  when remainders is changing -
                    cnt = 1;

                    start = rem;

                }
            }

            return max;

        }
    }

//    brute force- gives TLE
    public static  int resilientSubarray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int res = 1;
        for (int i = 0; i < n; i++) {
            sum = 0;
            if (sum % k != 0)
                break;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                int temp_sum = sum;
                boolean flag = false;
                for (int l = j; l >= i; l--) {
                    // temp_sum -= nums[l];
                    if ((temp_sum - nums[l]) % k != 0)
                        break;

                    if (l == i)
                        flag = true;

                }

                if (flag)
                    res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(resilientSubarray(new int[]{5 , 5 , 4 , 8}  , 4));
    }
}
