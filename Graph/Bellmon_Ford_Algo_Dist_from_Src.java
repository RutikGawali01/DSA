
import java.util.*;

public class Bellmon_Ford_Algo_Dist_from_Src {

    public static int[] bellmon_ford(int n, int src, int[][] edges) {
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        for (int i = 0; i < v - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        //  nth relaxation to check negative cycle - 
        // for -ve cycles 
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }

        return dist;
    }

    public static void main(String[] args) {

    }
}
