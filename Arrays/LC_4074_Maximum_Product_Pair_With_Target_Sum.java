import java.util.HashMap;

public class LC_4074_Maximum_Product_Pair_With_Target_Sum {

        public static int[] maxProductPair(int[] nums, int target) {
            int n = nums.length;

            HashMap<Integer, Integer> map = new HashMap<>();
            int[] res = new int[2];
            res[0] = -1;
            res[1] = -1;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                int rem = target - nums[i];
                if (map.containsKey(rem)) {
                    int j = map.get(rem);
                    int prod = nums[i] * nums[j];
                    if (nums[i] < nums[j] && prod > max) {
                        max = prod;
                        res[0] = j;
                        res[1] = i;

                    } else if (nums[i] > nums[j] && prod > max) {

                        max = prod;
                        res[0] = i;
                        res[1] = j;

                    }
                }
                map.put(nums[i], i);
            }
            return res;
        }


    public static void main(String[] args) {
        int[] nums = {1,-6};
         int  target = -5;
        int[] res = maxProductPair(nums , target);
        System.out.println(res[0]);
        System.out.println(res[1]);


    }
}
