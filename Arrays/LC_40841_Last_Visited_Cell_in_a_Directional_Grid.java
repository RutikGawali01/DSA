public class LC_40841_Last_Visited_Cell_in_a_Directional_Grid {
    class Solution {
        public int[] lastVisitedCell(char[][] grid) {
            int n = grid.length; // rows
            int m = grid[0].length; // cols

            // in this question - we can remove vis array
            // if visited change char  from grid with some - special character # -
            // if that char appears - stops-
            // solution becomes - O(1) space

            boolean[][] vis = new boolean[n][m];
            int res[] = new int[2];
            int row = 0;
            int col = 0;

            while ((row < n && row >= 0 &&  col>= 0 && col < m) && !vis[row][col]) {
                vis[row][col] = true;
                res[0] = row;
                res[1] = col;
                if (grid[row][col] == 'R') {
                    col++;
                } else if (grid[row][col] == 'L') {
                    col--;
                } else if (grid[row][col] == 'D') {
                    row++;
                } else {
                    row--;
                }
            }
            return res;
        }
    }
}
