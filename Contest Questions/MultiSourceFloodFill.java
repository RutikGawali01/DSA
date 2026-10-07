import java.util.*;

// optimal solution - 
class Solution {
    static class Pair {
        int row, col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] mat = new int[n][m];
        // Use -1 to represent unvisited cells
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, -1);
        
        Queue<Pair> q = new LinkedList<>();

        // 1. Sort sources by color descending. 
        // This ensures the largest color "wins" ties during BFS.
        Arrays.sort(sources, (a, b) -> Integer.compare(b[2], a[2]));

        // 2. Add all sources to the queue
        for (int[] source : sources) {
            int r = source[0], c = source[1], color = source[2];
            // If multiple sources occupy the same cell, the largest color (sorted) stays
            if (dist[r][c] == -1) {
                mat[r][c] = color;
                dist[r][c] = 0;
                q.add(new Pair(r, c));
            }
        }

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        // 3. Standard BFS
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int r = curr.row;
            int c = curr.col;

            for (int i = 0; i < 4; i++) {
                int nr = r + delRow[i];
                int nc = c + delCol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    // Scenario A: Cell is unvisited
                    if (dist[nr][nc] == -1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        mat[nr][nc] = mat[r][c];
                        q.add(new Pair(nr, nc));
                    } 
                    // Scenario B: Tie-breaker (reached at same distance)
                    else if (dist[nr][nc] == dist[r][c] + 1) {
                        mat[nr][nc] = Math.max(mat[nr][nc], mat[r][c]);
                    }
                }
            }
        }
        return mat;
    }
}




public class MultiSourceFloodFill{
    static  class Pair{
        int row;
        int col;
         int level;
        public Pair(int row ,int col , int level){
            this.row  = row;
            this.col = col;
            this.level = level;
        }
    }

    public static boolean isValid(int n , int m , int row , int col){
        return  row < n && row>= 0 && col < m  && col>= 0;
    }

    // we can optimized this solution by sorting sorces in deceresing order -
    //and in there it is not neccesary to use levels
    public static int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] mat = new int[n][m]; 
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for(int[] source : sources){
            int r = source[0];
            int c = source[1];
            int color = source[2];

            mat[r][c] = color;

            q.add(new Pair(r , c, 0));
            vis[r][c] = 0;
        }
        int delrow[] = {-1 , 1, 0 , 0};
        int delcol[] = {0 , 0 , -1 , 1};
        

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int level = p.level;
            int currcolor = mat[row][col];

            for(int i = 0 ; i < 4 ; i++){
                int adjrow = row + delrow[i];
                int adjcol = col + delcol[i];

                if(isValid(n, m, adjrow, adjcol) && mat[adjrow][adjcol] == 0 && vis[adjrow][adjcol] == 0){
                    q.add(new Pair(adjrow , adjcol , level+1));
                    mat[adjrow][adjcol] = currcolor;
                    vis[adjrow][adjcol] = level+1;
                }else if(isValid(n, m, adjrow, adjcol) && vis[adjrow][adjcol]-1 == level ){
                    mat[adjrow][adjcol] = Math.max(mat[adjrow][adjcol] , currcolor);
                   vis[adjrow][adjcol] = level+1;
                }
            }

        }
        return mat;
        
        
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] sources = {{0,1,3},{1,1,5}};;

        int[][] ans = colorGrid(n, m, sources);

        for(int i = 0; i< n ; i++){
            for(int j = 0; j < m ; j++){
                System.out.print(ans[i][j]+ "-");
            }
            System.out.println();
        }
        
    }
}