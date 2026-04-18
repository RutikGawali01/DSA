import java.util.*;
public class Shortest_Path_WeightedGraph{
    static class Pair{
        int v; 
        int wt;

        public Pair(int v ,int wt){
            this.v = v;
            this.wt = wt;
        }
    }


    public static ArrayList<Integer> shortestPath(int v , int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i< v; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int U = edge[0];
            int V = edge[1];
            int w = edge[2];

            adj.get(U).add(new Pair(V, w));
            adj.get(U).add(new Pair(U, w));

        }

       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

           dist[1] = 0;
        pq.offer(new int[]{0, 1});

        int[] parent = new int[v];

        for(int i = 0 ; i< v ; i++){
            parent[i] = i;
        }

        while(!pq.isEmpty()){
             int[] curr = pq.poll();
            int dis = curr[0];  // Distance of the current node
            int node = curr[1];  // Current node
            

            for(Pair p : adj.get(node)){
                int adjNode = p.v;
                int weight = p.wt;
            
           

                // If the new calculated distance is smaller, update it
                if (dis + weight < dist[adjNode]) {
                    dist[adjNode] = dis + weight;
                    parent[adjNode] = node;
                    pq.offer(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        int temp = v;
        ArrayList<Integer> ans = new ArrayList<>();

        while(parent[temp] != temp){
            ans.add(temp);
            temp = parent[temp];
        }
        ans.add(1);

        return ans;

    }
    public static void main(String[] args) {
        
    }
}