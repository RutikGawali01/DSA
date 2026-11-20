public class LC_4075_Longest_Resilient_Subarray_II {
    class Solution {
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
}
