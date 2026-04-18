
import java.util.ArrayList;
import java.util.Stack;

public  class  Topo_Sort{
     public void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] vis , Stack<Integer> st){
        vis[node] = true;
        
        for(int it : adj.get(node)){
            if(!vis[it]){
                dfs(it , adj , vis , st);
            }
        }
        
        st.push(node); // must be  at last - 
        
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        //converting edges into adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v); // only one direction for directed graph
        }
        
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i< V ; i++){
            if(!vis[i]){
                dfs(i , adj , vis , st);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(!st.isEmpty()){
            res.add(st.pop());
        }
        return res;
        
    }

    public static void main(String[] args) {
        
        int V = 4;

        int E = 3;
        int edges[][] = [[3, 0], [1, 0], [2, 0]]
    }
}