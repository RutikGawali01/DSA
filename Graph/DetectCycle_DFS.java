
import java.util.*;

public class DetectCycle_DFS{

    public static boolean  DFS(int node , int parent , List<List<Integer>> adj , boolean[] vis){
        vis[node] = true;

        for(Integer it : adj.get(node)){
            if(!vis[it]){
                if(DFS(it, node, adj, vis)){
                    return  true;
                }
            }else if( it != parent){
                return true;
            }
        }

        return false;

    }


    public static  boolean isCycle(int v, int[][] edges) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        // Build adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int w = edge[1];
            adj.get(u).add(w);
            adj.get(w).add(u);
        }
       
        boolean[] vis = new boolean[v];
        
        for(int i = 0 ; i< v ; i++){
            if(vis[i] == false){
                if(DFS(i ,-1, adj, vis)){
                    return true;
                }
            }
        }
        return false;
        
    }



    public static void main(String[] args) {
         int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
         int v = 4;
         System.out.println(isCycle(v, edges));
    }
}