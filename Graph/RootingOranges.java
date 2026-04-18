
import java.util.*;

public class RootingOranges {

    static class Pair {

        int x;
        int y;
        int min;

        Pair(int x, int y, int min) {
            this.x = x;
            this.y = y;
            this.min = min;
        }
    }


    public static int orangesRotting(int[][] grid) {
        
        
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};
        int[][] vis = new int[n][m];// visited contain either 0 or 2  ----- 2 for rotten visited at that  place

        int cntFresh = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j , 0));
                    vis[i][j] = 2; 
                }else{
                    vis[i][j] =0;
                }
                if(grid[i][j] == 1) cntFresh++;
            }
        }

       
        int time = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int ro = p.x;
            int co = p.y;
            int mi = p.min;
            time  = Math.max(time, mi); 

            for(int i = 0  ; i< 4 ; i++){
                int row = ro+ delRow[i];
                int col = co + delCol[i];

                if(row < n && row>= 0 && col < m && col>= 0 && vis[row][col] != 2 &&  grid[row][col] == 1){
                    q.add(new Pair(row , col , mi+1));
                    vis[row][col] = 2;
                    cnt++;
                }
            }
           
        }

        for(int i = 0; i< n ; i++){
            for(int j = 0; j < m ; j++){
                if(vis[i][j] != 2 && grid[i][j] == 1){
                    return  -1;
                } 
            }
        }

        if(cnt != cntFresh) return -1;

        return time;

    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
}
