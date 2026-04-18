
import java.util.ArrayList;

public class DirectedGraphCycle_DFS{

    public static boolean dfs(int node , boolean[] vis , ArrayList<ArrayList<Integer>> adj , boolean [] pathvis){
        vis[node] = true;
        pathvis[node] = true;

        for(Integer it : adj.get(node)){
            if( !vis[it]){ //  not visited 
                if(dfs(it, vis, adj , pathvis)) return  true;
            }
            // previously visited but it should visited on the same path 
            // so if pathvis[it] == true  -- cycle present
            else if(pathvis[it]){
                return  true;
            }
        }
        pathvis[node] = false;
        return  false;
    }

    public static  boolean isCyclic(int V, int[][] edges) {
        // creating adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V  ; i++){
            adj.add(new ArrayList<>());
        }


        for(int[] edge : edges ){
           int u = edge[0];
           int  v = edge[1];

           adj.get(u).add(v);
        }


        boolean[] vis = new boolean[V];
        boolean[] pathvis = new boolean[V];

        for(int i = 0 ; i < V ; i++){
            if(!vis[i] ) {
                if(dfs(i, vis, adj, pathvis)){ //  returns true when cycle is found 
                    return  true;
                }
            }           
        }
        return false;

    }   

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = {{0, 1}, {1, 2}, {2, 0} ,{2, 3}};
        System.out.println(isCyclic(V, edges));
    }
}