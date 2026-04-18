import java.util.*;
public class Number_of_Provinces_DisjointSet{
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


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int cnt = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0;i<n ;i++){
            for(int j = 0; j< n ;j++){
                if(isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        for(int i = 0 ; i< n ; i++){
            if(ds.findParent(i) == i){
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        
    }
}