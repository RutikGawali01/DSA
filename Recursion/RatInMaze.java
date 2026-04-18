

public class  RatInMaze{
    public static void findDestinationForRat(int row, int col, int[][] mat , String path , int[][] vis , int n){
        if(row == n-1 && col == n-1){
            System.out.println(path);
            return;
        }

        //down 
        if(row+1< n && mat[row+1][col] == 1 && vis[row+1][col] == 0){
            vis[row][col] = 1;
            findDestinationForRat(row+1, col, mat, path + 'D', vis, n);
            vis[row][col] = 0;
        }

        //left 
        if( col-1 >= 0 && mat[row][col-1] == 1 && vis[row][col-1] == 0){
            vis[row][col] = 1;
            findDestinationForRat(row, col-1, mat, path + 'L', mat, n);
            vis[row][col] = 0;
        }

        //right
        if(col+1 < n && mat[row][col+1] == 1 && vis[row][col+1] == 0){
            vis[row][col] = 1;
            findDestinationForRat(row, col+1, mat, path+'R' , vis, n);
            vis[row][col] = 0;
        }

        // Up
        if( row-1 >= 0 && mat[row-1][col] == 1 && vis[row-1][col] == 0){
            vis[row][col] = 1;
            findDestinationForRat(row, col+1, mat, path+'U' , vis, n);
            vis[row][col] = 0;
        }

        
    }


    public static void solve(int i, int j , int[][] mat , int[][] vis , String path , int  n , int[] di , int[] dj){
        if(i == n-1 && j == n-1){
            System.out.println(path);
            return;
        }
        String dir = "DLRU";
        for(int ind = 0 ; ind < 4 ; ind++){
            int nexti = i+di[ind];
            int nextj = j+dj[ind];
            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && mat[nexti][nextj] == 1 && vis[nexti][nextj] == 0){
                vis[i][j] = 1;
                solve(nexti, nextj, mat, vis, path + dir.charAt(ind) , n, di, dj);
                vis[i][j] = 0;
            }

        }

    }

    public static void main(String[] args) {
        int[][] mat = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        int n = 4;
        int[][] vis = new int[n][n];
        //findDestinationForRat(0, 0, mat, "", vis, n);
        
        int[] di  = {1,0,0, -1};
        int[] dj = {0,-1, 1 , 0};


        solve(0, 0, mat, vis, "", n, di, dj);
    }

}