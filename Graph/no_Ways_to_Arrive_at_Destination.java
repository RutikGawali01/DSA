import java.util.*;

public class no_Ways_to_Arrive_at_Destination{
    static class Pair {
        long time;
        int node;

        public Pair(long time, int node) {
            this.time = time;
            this.node = node;
        }
    }


    public static  int countPaths(int n, int[][] roads) {
        //  long mod = (long)1e9 + 7;
         long mod = 1_000_000_007L;

       List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : roads) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new long[]{v, w});
            adj.get(v).add(new long[]{u, w});
        }


        // {time , node}
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.time, y.time));
        long[] dist = new long[n];
        long[] ways = new long[n];
        
        Arrays.fill(dist, Long.MAX_VALUE);
        
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

   


        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long currTime = curr.time;
            int currnode = curr.node;

            for (long[] neighbor : adj.get(u)) {
                int adjnode = (int) neighbor[0];
                long weight = neighbor[1];

                if (dist[currnode] + weight < dist[v]) {
                    dist[adjnode] = dist[currnode] + weight;
                    ways[adjnode] = ways[currnode];
                    pq.add(new Pair(dist[adjnode], adjnode));
                } 
                else if (dist[currnode] + weight == dist[adjnode]) {
                    ways[adjnode] = (ways[adjnode] + ways[currnode]) % mod;
                }
            }


        }
        return (int)ways[n-1];

    }

}