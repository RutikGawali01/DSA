
import java.lang.reflect.Array;
import java.util.*;
class Edge{
    int wt;
    int node;
    int parent;

    public Edge(int wt , int node , int parent){
        this.wt = wt;
        this.node = node;
        this.parent = parent;
    }
}

public class Prims_Algo{
    public static int spanningTree(int V, int[][] edges) {
         // create Adj list from edges - 
        ArrayList<ArrayList<int []>> adj = new ArrayList<>();
        for(int i = 0; i<V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }
         boolean[] vis = new boolean[V];
       
        int sum = 0;
         PriorityQueue<Edge> pq = new PriorityQueue<>((a, b)-> a.wt - b.wt);

         ArrayList<int[]> mst  = new ArrayList<>();


         pq.add(new Edge(0 , 0 , -1));

         while(!pq.isEmpty()){
            Edge edge =  pq.poll();
            int currwt = edge.wt;
            int currnode  = edge.node;
            int parent  = edge.parent;

            if(vis[currnode]) continue;

            sum+= currwt;

            vis[currnode] = true;
            mst.add(new int[]{parent , currnode});

            for( int[] it : adj.get(currnode)){
                int adjnode = it[0];
                int adjwt = it[1];
                if(!vis[adjnode]){
                    pq.add(new Edge(adjwt, adjnode, parent));
                }

            }

         }

         return sum;
        
    }

    public static void main(String[] args) {
        
    }
}