
import java.util.*;

public class Kahns_Algo_TopoSort_BFS {

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            indegree[v]++;
            adj.get(u).add(v);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (Integer it : adj.get(node)) {
                if (indegree[it] != 0) {
                    indegree[it]--;
                }

                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {

        int V = 4;

        int E = 3;
        int edges[][] = {{3, 0}, {1, 0}, {2, 0}};

        topoSort(V, edges);
    }
}
