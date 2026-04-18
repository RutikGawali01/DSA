
import java.util.*;

public class network_Delay_Time {
//  in adj - {node , time}
    // in Priority Queue - {time , nnode}
    static class Pair {

        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : times) {
            int U = edge[0];
            int V = edge[1];
            int w = edge[2];

            adj.get(U).add(new Pair(V, w));
        }
        // {time , node}
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.first - y.first);
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        dist[k] = 0;
        pq.add(new Pair(0, k));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int currTime = pair.first;
            int currnode = pair.second;

            if (currTime > dist[currnode]) continue;

            for (Pair p : adj.get(currnode)) {
                int adjnode = p.first;
                int adjtime = p.second;
                if (currTime + adjtime < dist[adjnode]) {
                    dist[adjnode] = currTime + adjtime;
                    pq.add(new Pair(dist[adjnode], adjnode));
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(dist[i], max);
        }

        return max;

    }

    public static void main(String[] args) {

    }
}
