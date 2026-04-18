
import java.util.*;

public class DistinctIsland {

    public static void Dfs(int ro, int co, int[][] grid, boolean[][] vis, ArrayList<ArrayList<Integer>> shape, Set<ArrayList<ArrayList<Integer>>> set, int[] base, int[] delRow, int[] delCol) {
        vis[ro][co] = true;
        int Brow = base[0]; // base row  
        int Bcol = base[1]; // base col

        int n = grid.length;
        int m = grid[0].length;

        ArrayList<Integer> path = new ArrayList<>();

        path.add(ro - Brow);
        path.add(co - Bcol);
        shape.add(path);

        for (int i = 0; i < 4; i++) {
            int nrow = ro + delRow[i];
            int ncol = co + delCol[i];

            if (nrow < n && nrow >= 0 && ncol < m && ncol >= 0 && grid[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                Dfs(nrow, ncol, grid, vis, shape, set, base, delRow, delCol);

            }
        }

    }

    public static int countDistinctIsshapes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<ArrayList<ArrayList<Integer>>> set = new HashSet<>();

        boolean vis[][] = new boolean[n][m];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    ArrayList<ArrayList<Integer>> shape = new ArrayList<>();
                    Dfs(i, j, grid, vis, shape, set, new int[]{i, j}, delRow, delCol);
                    // we can directly pass base co-ordinates bcz  there is only 2 co - ordinates   
                    set.add(shape);
                }
            }
        }
        return set.size();

    }

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 0, 1, 1},
        {1, 0, 0, 0, 0},
        {0, 0, 0, 0, 1},
        {1, 1, 0, 1, 1}};

        System.out.println(countDistinctIsshapes(grid));
    }
}
