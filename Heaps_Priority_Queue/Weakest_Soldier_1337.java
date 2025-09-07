
import java.util.PriorityQueue;

public class Weakest_Soldier_1337{
    // leetcode 1337
    public static class Row implements Comparable<Row>{
        int soldiers;
        int ind;

        public Row(int soldiers , int ind){
            this.soldiers = soldiers;
            this.ind = ind;
        }

        @Override
        public int compareTo(Row r2){
            // if soldiers are equal in both rows then  on the basis of index 
            if(this.soldiers == r2.soldiers){
                return this.ind - r2.ind;
            }else{
                return this.soldiers -r2.soldiers;
            }
        }
    }

    public static int[] weakestSoldier(int[][] mat , int k){

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for(int i = 0 ; i<mat.length; i++){
            int count = 0;
            for(int j = 0; j<mat[0].length; j++){
                count+= mat[i][j] == 1 ? 1 : 0 ;
            }
            pq.add(new Row(count , i));
        }

        int[] res = new int[k];
        for(int i = 0; i<k; i++){
            res[i] =  pq.remove().ind;
        }
        return res;
    }

    public static void main(String[] args) {
    int [][] mat = {{1,0,0,0},
                    {1,1,1,1},
                    {1,0,0,0},
                    {1,0,0,0}
                    };
                    
    int k  = 2;

    int [] ans = weakestSoldier(mat, k);
    for(int i = 0; i<k;i++){
        System.out.println("R" + ans[i]);
    }

    }
}