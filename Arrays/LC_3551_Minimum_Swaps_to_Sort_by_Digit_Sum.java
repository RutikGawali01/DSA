import java.util.Arrays;

public class LC_3551_Minimum_Swaps_to_Sort_by_Digit_Sum {
    public int digsum(int ele) {

        int sum = 0;
        while (ele > 0) {
            sum += ele % 10;
            ;
            ele = ele / 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        // {0 - ele , 1 - digsum  , 2 - origi-pos }
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; // ele
            arr[i][1] = digsum(nums[i]); // dig-sum
            arr[i][2] = i; // original ind

        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                // sort on basis of ele if dig sum equals
                return Integer.compare(a[0], b[0]);
            }
            // sort on basis of digit sum
            return Integer.compare(a[1], b[1]);
        });

        int swaps = 0;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (vis[i])
                continue;
            // i - target ind after sorting with 2  given conditions -

            // if   not included in any cycle
            int tar_pos = i;
            int cycle_len = 0;

            while (!vis[tar_pos]) {
                vis[tar_pos] = true;
                // origi pos for that particular ele index
                tar_pos = arr[tar_pos][2];
                cycle_len++;
                // 0-3-0-- cycle len  - 2

            }
            if (cycle_len > 1) {
                swaps += cycle_len - 1;
            }
        }

        return swaps;

    }
}
