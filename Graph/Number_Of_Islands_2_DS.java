import java.util.*;
public class Number_Of_Islands_2_DS{
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




    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        
       
        int[][] vis = new int[rows][cols];

        int[] delRow = {-1,0,+1,0};
        int[] delCol = {0,+1,0,-1};
        DisjointSet ds = new DisjointSet(rows*cols);

        int cnt = 0;

        List<Integer> res = new ArrayList<>();

        for(int[] cell : operators){
            int i = cell[0];
            int j = cell[1];

            if(vis[i][j] == 1){
                res.add(cnt);
                continue;
            } 
            vis[i][j]  = 1;
            cnt++;

            for(int ind = 0  ; ind < 4 ; ind++){
                
                int nro =  i+delRow[ind];
                int ncol = j+delCol[ind];
                
                if(nro < rows && nro >= 0 && ncol < cols  &&  ncol >= 0){
                    // adj is land
                    if(vis[nro][ncol] == 1){
                        int nodeNo = i*cols +  j;
                        int adjNodeNo = nro*cols + ncol;
                        // connect if not  belongs to the same components and 
                        if(ds.findParent(nodeNo) != ds.findParent(adjNodeNo)){
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                   
                }
            }  
            res.add(cnt);    
        }
        return res;
    }
}