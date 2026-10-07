
import java.util.*;

public class FilterOccupied_Intervals_Weekly_504_q2 {

    /*
    You are given a 2D integer array occupiedIntervals, where occupiedIntervals[i] = [starti, endi] represents a time interval during which you are occupied. Each interval starts at starti and ends at endi, inclusive. These intervals may overlap.

You are also given two integers freeStart and freeEnd, which define a free time interval from freeStart to freeEnd, inclusive.

Your task is to merge all occupied intervals that overlap or touch, then remove all integer points in the free interval from the merged occupied intervals.

Two intervals touch if the second interval starts immediately after the first one ends. For example, [1, 1] and [2, 2] touch and should be merged into [1, 2].

Return the remaining occupied intervals in sorted order. The returned intervals must be non-overlapping and must contain the minimum number of intervals possible. If there are no remaining occupied points, return an empty list.

 

Example 1:

Input: occupiedIntervals = [[2,6],[4,8],[10,10],[10,12],[14,16]], freeStart = 7, freeEnd = 11

Output: [[2,6],[12,12],[14,16]]

Explanation:

After merging, the occupied intervals are [2, 8], [10, 12], and [14, 16].
Excluding the free interval [7, 11] results in [2, 6], [12, 12], and [14, 16].
Example 2:

Input: occupiedIntervals = [[1,5],[2,3]], freeStart = 3, freeEnd = 8

Output: [[1,2]]

Explanation:

After merging, the occupied interval is [1, 5].
Excluding the free interval [3, 8] results in [1, 2].
 

Constraints:

1 <= occupiedIntervals.length <= 5 * 104
occupiedIntervals[i].length == 2
1 <= starti <= endi <= 109
1 <= freeStart <= freeEnd <= 109

     */
    public void helper(List<List<Integer>> res, int prev_start, int prev_end, int freeStart, int freeEnd) {
        if (prev_end < freeStart || prev_start > freeEnd) {
            res.add(Arrays.asList(prev_start, prev_end));
            return;
        }
        if (prev_start < freeStart) {
            res.add(Arrays.asList(prev_start, freeStart - 1));
        }

        if (prev_end > freeEnd) {
            res.add(Arrays.asList(freeEnd + 1, prev_end));
        }

    }

    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        int n = occupiedIntervals.length;
        Arrays.sort(occupiedIntervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prev_start = occupiedIntervals[0][0];
        int prev_end = occupiedIntervals[0][1];

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int curr_start = occupiedIntervals[i][0];
            int curr_end = occupiedIntervals[i][1];

            if (curr_start <= prev_end + 1) {
                prev_end = Math.max(curr_end, prev_end);
            } else {
                // List<Integer> temp = new ArrayList<>();

                // if (prev_start < freeStart || prev_end > freeEnd) {
                //     res.add(Arrays.asList(prev_start, prev_end));
                //     continue;
                // }
                // if (prev_start < freeStart) {
                //     res.add(Arrays.asList(prev_start, freeStart - 1));
                // }
                // if (prev_end > freeEnd) {
                //     res.add(Arrays.asList(freeEnd + 1, prev_end));
                // }
                // if(prev_start >= freeStart){
                //     prev_start = freeEnd+1;
                // }
                // if( (prev_end >= freeStart )  && ( prev_end <= freeEnd) ){
                //     prev_end = freeStart-1;
                // }
                // temp.add(prev_start);
                // temp.add(prev_end);
                // res.add(temp);
                helper(res, prev_start, prev_end, freeStart, freeEnd);
                prev_start = curr_start;
                prev_end = curr_end;
            }
        }

        // if (prev_start < freeStart || prev_end > freeEnd) {
        //     res.add(Arrays.asList(prev_start, prev_end));
        // }
        // if (prev_start < freeStart) {
        //     res.add(Arrays.asList(prev_start, freeStart - 1));
        // }
        // if (prev_end > freeEnd) {
        //     res.add(Arrays.asList(freeEnd + 1, prev_end));
        // }
        helper(res, prev_start, prev_end, freeStart, freeEnd);

        return res;

    }

}
