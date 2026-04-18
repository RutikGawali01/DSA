import java.util.*;
public class BfsInGraph{
    // breadth for search in graph -- level wise
    public static ArrayList<Integer> BfsofGraph(int vertex , ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[adj.size()];

        ArrayList<Integer> res = new ArrayList<Integer>();

        
        vis[vertex] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(vertex);

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return res;


    }
    public static void main(String[] args) {
        
         
    }
}