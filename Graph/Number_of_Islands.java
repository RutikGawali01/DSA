public class Number_of_Islands{
    // Number_of_Islands -- connected components

     public static void dfs(int ro, int co, char[][] grid, boolean[][] vis, int[] delRow, int[] delCol) {
        vis[ro][co] = true;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nro = ro + delRow[i];
            int nco = co + delCol[i];

            if (nro < n && nro >= 0 && nco < m && nco >= 0 && vis[nro][nco] != true && grid[nro][nco] == '1') {
                dfs(nro, nco, grid, vis, delRow, delCol);
            }
        }

    }

     public static int numIslands(char[][] grid) {
        int n  =   grid.length;
        int m = grid[0].length;
         boolean[][] vis = new boolean[n][m];
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        int count = 0;


        for( int i = 0 ; i< n ; i++){
            for(int  j  = 0; j< m ; j++){
                if(!vis[i][j] && grid[i][j] =='1'){
                    count++;
                    dfs(i , j , grid , vis , delRow , delCol);
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        char[][]  grid = {
                    {'1','1','0','0','0'},
                    {'1','1','0','0','0'},
                    {'0','0','1','0','0'},
                    {'0','0','0','1','1'}
                } ;
        
        System.out.println(numIslands(grid));
    }   
}