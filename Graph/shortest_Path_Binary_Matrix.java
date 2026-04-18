
import java.util.*;

public class shortest_Path_Binary_Matrix{
    static class Pair{
        int i;
        int j;
        int dist;

        public Pair(int i , int j , int dist){
            this.i = i;
             this.j = j;
             this.dist = dist;
        }
    }

    public static  int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        Queue<Pair> q = new LinkedList<>();
        // if 0 , 0 is  ---> 1 return -1 -- path can  not exists
        if(grid[0][0] == 1){
            return -1;
        }

        q.add(new Pair(0, 0, 1));

        while(!q.isEmpty()){
            Pair p  = q.poll();
            int i = p.i;
            int j = p.j;
            int dist  = p.dist;
            
            if(i == n-1 && j == n-1){
                return dist;
            }

            // traverse in 8 adj side

            for(int delRow = -1 ; delRow <= 1 ; delRow++){
                for(int delCol = -1 ; delCol <= 1 ; delCol++){
                    int nrow  = i + delRow;
                    int ncol = j + delCol;

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0){
                        grid[nrow][ncol] = 1; // mark as visited or we can use vis array
                        q.add(new Pair(nrow , ncol , dist+1)); // add in qeue
                    }
                }
            }

        }
        return -1;
        
        
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));

    }
}