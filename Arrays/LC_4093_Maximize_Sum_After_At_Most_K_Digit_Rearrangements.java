import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_4093_Maximize_Sum_After_At_Most_K_Digit_Rearrangements {



    class Solution {
        public long maximizeSum(int[] nums, int k) {
            int n = nums.length;

            long sum = 0;
            // Arrays.sort(nums);
            // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
            // this does not work -
            // ex - [ 34, 17 ] k = 1 .
            // here max we can make from 17 => 71 diff = 54
            // max we can make from 34 => 43 diff = 9

            // now clearly we know the 54 will contribute more in array sum to make it larger, so spend your operation wisely ( greedily )

            // ex == [26,6,37,41,27,29] k == 2
            // for  if we choose - 92 and 73 and if we choose 73 instead of 72 - we adding 27 but if we choose 72 we add 37
            // dry run this once

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[2], a[2]));

            // [sort , ele ]

            for (int i = 0; i < n; i++) {
                int ele = nums[i];

                int[] freq = new int[10];

                while (ele != 0) {
                    freq[ele % 10]++;
                    ele = ele / 10;
                }
                int sort = 0;
                for (int j = 9; j >= 0; j--) {
                    while (freq[j] > 0) {
                        sort = sort * 10;
                        sort += j;
                        freq[j]--;
                    }
                }

                if (sort >= nums[i]) {
                    pq.add(new int[] { sort, nums[i], sort - nums[i] });
                }

            }

            while (!pq.isEmpty()) {
                int[] tmp = pq.peek();
                if (k != 0 && tmp[0] != tmp[1]) {
                    sum += tmp[0];
                    k--;
                } else {
                    sum += tmp[1];
                }
                pq.poll();
            }
            return sum;
        }
    }



    public static void main(String[] args) {

        System.out.println(maximizeSum(new int[]{102,90,14} , 2));

    }
}
