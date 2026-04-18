import java.util.*;
public class minimumEffortPath{
    static class Tuple{
        int dist;
        int ro;
        int col;
        public Tuple(int dist , int ro , int col){
            this.dist = dist;
            this.ro = ro;
            this.col = col;
        }
    }

    public static  int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m]; // this is  for the track of min effor during path -

        //  this only works for 1D array
        // Arrays.fill(dist, (int)(1e9));

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j< m ; j++){
                dist[i][j] = (int)(1e9);
            }
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.dist - y.dist);
        pq.add(new Tuple(0 , 0 ,0)); // { dist ,  row , col}
        dist[0][0] = 0;

       int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};

        while(!pq.isEmpty()){
            Tuple curr = pq.poll();
            int currDist = curr.dist;
            int row = curr.ro;
            int col = curr.col;

            if(row == n-1 && col == m-1) return currDist;


            // traverse all 4 adj sides
            for(int i  = 0 ; i< 4 ; i++){
                int nrow = row + delRow[i];
                int ncol  = col + delCol[i]; 
                
                if(nrow>= 0 && nrow < n && ncol >= 0 && ncol < m ){
                    int diff =  Math.abs(heights[row][col] - heights[nrow][ncol]);
                    int newEffort = Math.max(diff , currDist);
                    if( newEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = newEffort;
                        pq.add(new Tuple(dist[nrow][ncol] , nrow , ncol));
                    }

                }

            }

        }

        return 0; // this is unreachable

    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println(minimumEffortPath(heights));
    }
}