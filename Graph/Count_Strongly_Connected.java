
import java.util.ArrayList;
import java.util.Stack;

public class Count_Strongly_Connected{
    // Step 1 DFS: Push nodes to stack based on finishing time
    public static void dfs(int i  , boolean [] vis , ArrayList<ArrayList<Integer>> adj  , Stack<Integer> st){
        vis[i]  = true;
        for(Integer it : adj.get(i)){
            if(!vis[it]){
                dfs(it, vis, adj, st);
            }   
        }
        st.push(i);
    }
    // Step 3 DFS: Traverse the transposed graph
    public static void dfsforcount(int i , boolean[] vis , ArrayList<ArrayList<Integer>> adjT ){
        vis[i]  = true;
        for(Integer it : adjT.get(i)){
            if(!vis[it]){
                dfsforcount(it, vis, adjT);
            }
        }
    }

    public static int kosaraju(int V, int[][] edges) {
        boolean[] vis = new boolean[V];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i<V  ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u  = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        // 1. Get nodes in order of finishing time
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i< V ; i++){
            if(!vis[i]){
                dfs(i, vis, adj, st);
            }
        }

        // reverse thhre graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for(int i = 0 ; i<V  ; i++){
            adjT.add(new ArrayList<>());
        }
        for(int i = 0 ; i< V ; i++){
            vis[i] = false;
            for(Integer it : adj.get(i)){
                // i --> it convert it-> i
                adjT.get(it).add(i);
            }
        }

        //process nodes in stack order
        int scc  = 0;
        while(!st.isEmpty()){
            int top = st.pop();
            if(!vis[top]){
                scc++;
                dfsforcount(top , vis , adjT);
            }
        }

        return scc;

    }

    public static void main(String[] args) {
        
    }
}