import java.util.*;
public class Kruskals_Algorithm_MST{
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


    static class Edges implements  Comparable<Edges>{
        int u;
        int v ;
        int wt;

        public Edges(int u , int v , int wt){
            this.u = u;
            this.v = v;
            this.wt =wt;
        }

        public int compareTo(Edges comparEdges){
            return  this.wt - comparEdges.wt;
        };

    }

    public  static int kruskalsMST(int V, int[][] edges) {
        
        List<Edges> edgeses = new ArrayList<>();
        for(int[] edge : edges ){
            int u  = edge[0];
            int v = edge[1];
            int wt = edge[2];

            edgeses.add(new Edges(u, v, wt));
        }
        Collections.sort(edgeses);
        DisjointSet ds  = new DisjointSet(V);
        int mstwt = 0;

        for(int i = 0 ;i<edgeses.size() ; i++){
           int wt = edgeses.get(i).wt;
           int u = edgeses.get(i).u;
           int v = edgeses.get(i).v;
           
           if(ds.findParent(u) != ds.findParent(v)){
            mstwt+=wt;
            ds.unionBySize(u, v);
           }
        }
        return  mstwt;

    }

}