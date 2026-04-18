
import java.util.*;

public class DetectCycle_BFS{
    static class Pair{
        int x;
        int y;
        public Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean  BFS(List<List<Integer>> adj , boolean[] vis , int src){

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, -1));
        vis[src] = true;

        while(!q.isEmpty()){
            int node = q.peek().x;
            int parent  = q.peek().y;
            q.remove();

            for(Integer adjacent : adj.get(node)){
                if(!vis[adjacent]){
                    vis[adjacent] = true;
                    q.add(new Pair(adjacent, node));
                }else if(adjacent != parent){
                    return true;
                }
            }
        }


        return false;

    }
    public boolean isCycle(int v, int[][] edges) {
        
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
                if(BFS(adj , vis, i)){
                    return true;
                }
            }
        }
        return false;
        
    }


    public static void main(String[] args) {
        
    }
}