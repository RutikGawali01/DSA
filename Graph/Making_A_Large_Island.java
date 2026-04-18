import java.util.*;
public class Making_A_Large_Island{

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

    public static  int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};

        // disjoint set will be created with all components
        // connect comp if 1
        for(int i = 0 ; i< n  ; i++){
            for(int j =  0 ; j < n ; j++){
                if(grid[i][j] == 0) continue;
                // adjacent  nodes
                for(int ind = 0; ind < 4 ; ind++ ){
                    int adjro = i + delRow[ind];
                    int adjcol = j + delCol[ind];
                    
                    if( adjro < n  && adjro>=0 && adjcol< n && adjcol >= 0 && grid[adjro][adjcol] == 1){
                        int currnode = (i * n +j);
                            int adjnode = (adjro * n + adjcol);
                        ds.unionBySize(currnode, adjnode);
                    }
                } 
            }
        }

        int mx = 0;
        // step - 2 - 
        for(int i = 0 ; i< n  ; i++){
            for(int j =  0 ; j < n ; j++){
                if(grid[i][j] == 1) continue;
                Set<Integer> set = new HashSet<>();
                for(int ind = 0; ind < 4 ; ind++ ){
                    int adjro = i + delRow[ind];
                    int adjcol = j + delCol[ind];

                    if(adjro < n  && adjro>=0 && adjcol< n && adjcol >= 0 && grid[adjro][adjcol] == 1){
                        int adjnode = (adjro * n + adjcol);
                        set.add(ds.findParent(adjnode));
                    }

                }
                int sizetotal = 1;
                for(Integer it : set){
                    sizetotal += ds.size.get(it);
                }
                mx = Math.max(mx , sizetotal);
            }
        }

        //  if every  ele in grid is 0
        for(int cellno = 0 ; cellno < n*n  ; cellno++){
            mx = Math.max(mx , ds.size.get(ds.findParent(cellno)));
        }
        return mx;
    }

    public static void main(String[] args) {
        
    }
}