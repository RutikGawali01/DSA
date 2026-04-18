
import java.util.*;

public class Dist_of_near_cell_1 {
    //542. 01 Matrix 
    // this same solution works for above leetocode solution just chnage of 0 from 1
    // if (grid[i][j] == 1) {

        static class Pair {

            int x;
            int y;
            int dist;

            public Pair(int x, int y, int dist) {
                this.x = x;
                this.y = y;
                this.dist = dist;
            }
        }

        public static ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            int[] delRow = {-1, 0, +1, 0};
            int[] delCol = {0, +1, 0, -1};

            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ans.add(new ArrayList<>());
                for (int j = 0; j < m; j++) {
                    ans.get(i).add(0);   // initialize with 0
                }
            }

            boolean[][] vis = new boolean[n][m];

            Queue<Pair> q = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        vis[i][j] = true;
                        q.add(new Pair(i, j, 0));
                    }
                }
            }

            while (!q.isEmpty()) {
                Pair p = q.poll();
                int ro = p.x;
                int co = p.y;
                int Dist = p.dist;

                ans.get(ro).set(co, Dist);

                for (int i = 0; i < 4; i++) {
                    int nro = ro + delRow[i];
                    int nco = co + delCol[i];

                    if (nro < n && nro >= 0 && nco < m && nco >= 0 && vis[nro][nco] != true) {
                        vis[nro][nco] = true;
                        q.add(new Pair(nro, nco, Dist + 1));
                    }
                }

            }
            return ans;
        }

    public static void main(String[] args) {
        int grid[][] = {{0, 1, 1, 0},
        {1, 1, 0, 0},
        {0, 0, 1, 1}};
        System.out.println(nearest(grid));
    }
}
