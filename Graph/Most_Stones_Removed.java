
import java.util.*;

public class Most_Stones_Removed{
     static class DisjointSet{   
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent  = new ArrayList<>();
        List<Integer> size= new ArrayList<>();



        public DisjointSet(int n ){
            for(int i = 0 ; i<= n ; i++){
                size.add(1);
                rank.add(0);
                parent.add(i);
            }
        }

        /// find ultimate Parent - with path compresion 
        public  int findParent(int node){
            if(node == parent.get(node)) return node;
            int up = findParent(parent.get(node)); // backtrack  
            parent.set(node, up); // path compreseed
            return parent.get(node);

        }

        // 
        void unionByRank(int u , int v){
            // find ultimate parent of u and v
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            // belongs to the same commponents
            if(ulp_u == ulp_v) return;

            int ranku = rank.get(ulp_u);
            int rankv = rank.get(ulp_v);

            if(ranku < rankv){
                parent.set(ulp_u , ulp_v);
            }else if( ranku > rankv ){
                parent.set(ulp_v, ulp_u);
            }else{
                // rank equal 
                parent.set(ulp_v, ulp_u);

                rank.set( ulp_u , ranku +1) ; // update rank
            }

        }


        void unionBySize(int u , int v){
             // find ultimate parent of u and v
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);

            // belongs to the same commponents
            if(ulp_u == ulp_v) return;

            int sizeu = size.get(ulp_u);
            int sizev = size.get(ulp_v);

            
            if(sizeu < sizev){
                // attach smaller to larger - 
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v , sizeu+sizev);
            }else{
                // equal condition is covers in this - bcz in equal size/rank  we can connect anyone with anyonne
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u , sizeu+sizev);
            }
        }
    
    
    }


    public static int removeStones(int[][] stones) {
        int n = stones.length;

        int maxrow = 0;
        int maxcol = 0;

        for(int[] it : stones){
            maxrow = Math.max(maxrow , it[0] );
            maxcol = Math.max(maxcol, it[1]);
        }

        DisjointSet ds = new DisjointSet(maxrow + maxcol+1);
        HashMap<Integer , Integer> stonenodes = new HashMap<>();
        for(int[] it  : stones){
            int noderow = it[0];
            int nodecol = it[1]+maxrow +1;
            ds.unionBySize(noderow, nodecol);
            stonenodes.put(noderow, 1);
            stonenodes.put(nodecol, 1);  
        }

        // count no of component - 
        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : stonenodes.entrySet()) {
            if(ds.findParent(it.getKey()) == it.getKey()){
                cnt++;
            }
        }
        return n-cnt;
    }

    public static void main(String[] args) {
        
    }
}