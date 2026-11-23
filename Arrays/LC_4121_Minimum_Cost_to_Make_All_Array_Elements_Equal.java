public class LC_4121_Minimum_Cost_to_Make_All_Array_Elements_Equal {
    class Solution {
        public long findcost(int s, int e, int[] nums) {

            int n = nums.length;
            long cost = Long.MAX_VALUE;
            //
            // block  - start at 0
            if (s == 0 && e != n - 1) {
                // suffix
                cost = Math.min((long) (n - 1 - e) * (long) nums[e], cost);

            }
            // block is in complete array
            else if (s == 0 && e == n - 1) {
                return 0;
            }
            // block - in  middle
            else if (s != 0 && e != n - 1) {
                long pref = (long) s * (long) nums[s];
                long suf = (long) ((n - 1 - e) * (long) nums[e]);
                cost = Math.min(cost, (long) (pref + suf));
            }
            // block ends at n
            else if (s != 0 && e == n - 1) {
                cost = Math.min((long) s * (long) nums[s], cost);
            }

            return cost;

        }

        public long minCost(int[] nums) {
            int n = nums.length;
            // find  consucutive equal group and its start and end -  group of max len
            int start = 0;
            int end = 0;
            int len = 1;


            long cost = Long.MAX_VALUE;

            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1]) {
                    end = i;
                    len++;
                } else {
                    // if (end - start + 1 >=  len  ) {
                    //     minele = nums[start];
                    //     len = end - start + 1;
                    //     maxstart = start;
                    //     maxend = end;
                    // }
                    // if(  start != end && start != 0 && end != n-1){

                    // }

                    if (start == end && (start == n - 1 || start == 0) && (end == n - 1 || end == 0)) {

                    } else {
                        cost = Math.min(findcost(start, end, nums), cost);
                    }

                    start = i;
                    end = i;
                }
            }

            if (start == end && (start == n - 1 || start == 0) && (end == n - 1 || end == 0)) {

            } else {
                cost = Math.min(findcost(start, end, nums), cost);
            }

            return cost;

        }
    }
}
