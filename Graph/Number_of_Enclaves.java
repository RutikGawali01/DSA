
public class Number_of_Enclaves {
// 1020. Number of Enclaves
// we can also use BFS by storing all the boundary 1's in queue andd 
///then starting  while loop until queue becomes empty and
// and using visited while adding in bfs

    public static void dfs(int ro, int co, int[][] grid, boolean[][] vis, int[] delRow, int[] delCol) {
        vis[ro][co] = true;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nro = ro + delRow[i];
            int nco = co + delCol[i];

            if (nro < n && nro >= 0 && nco < m && nco >= 0 && vis[nro][nco] != true && grid[nro][nco] == 1) {
                dfs(nro, nco, grid, vis, delRow, delCol);
            }
        }

    }

    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for (int j = 0; j < m; j++) {
            //1st row
            if (!vis[0][j] && grid[0][j] == 1) {
                dfs(0, j, grid, vis, delRow, delCol);
            }
            // last row
            if (!vis[n - 1][j] && grid[n - 1][j] == 1) {
                dfs(n - 1, j, grid, vis, delRow, delCol);
            }
        }

        for (int i = 0; i < n; i++) {
            // 1st col
            if (!vis[i][0] && grid[i][0] == 1) {
                dfs(i, 0, grid, vis, delRow, delCol);
            }

            if (!vis[i][m - 1] && grid[i][m - 1] == 1) {
                dfs(i, m - 1, grid, vis, delRow, delCol);
            }
        }

        int count = 0 ;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    count = count+1;
                }
            }
        }
        return  count;

    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(grid));
    }
}
