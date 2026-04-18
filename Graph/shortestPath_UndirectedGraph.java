
import java.util.*;

public class shortestPath_UndirectedGraph {

    static class Pair {

        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    // we can solve this without using pair 
    // as we are updating  shortest path for that particular node -- so check that node shortest path insteaadd of using pair   

    public static int[] shortestPath(int V, int[][] edges, int src) {
        // build Adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] shortestPath = new int[V];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[src] = 0;

        Queue<Integer> q = new LinkedList<>();

        q.add(src);

        while (!q.isEmpty()) {
            int currnode = q.poll();

            for (Integer it : adj.get(currnode)) {
                if (shortestPath[currnode] != Integer.MAX_VALUE) {

                    if (shortestPath[it] > shortestPath[currnode] + 1) {
                        shortestPath[it] = shortestPath[currnode] + 1;
                        q.add(it);
                    }

                }

            }

        }
        for (int i = 0; i < V; i++) {
            if (shortestPath[i] == Integer.MAX_VALUE) {
                shortestPath[i] = -1;

            }
        }

        return shortestPath;
    }

    public static void main(String[] args) {
        int V = 9;
        int E = 10;

        int edges[][] = {{0, 1}, {0, 3}, {1, 2}, {3, 4}, {4, 5}, {2, 6}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};
        int src = 0;

        int[] ans = shortestPath(V, edges, src);

        for (int i = 0; i < V; i++) {
            System.out.println(ans[i] + "-");
        }

    }
}
