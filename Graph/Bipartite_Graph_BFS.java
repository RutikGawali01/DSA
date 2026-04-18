
import java.util.*;

public class Bipartite_Graph_BFS {

    public static boolean bfs(int src, int[][] edges, int[] color) {

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : edges[node]) {
                if (color[it] == color[node]) {
                    return false;
                } else {
                    if (color[node] == 0) {
                        if (color[it] == -1) {
                            q.add(it);
                            color[it] = 1;
                        }
                    } else if (color[node] == 1) {
                        if (color[it] == -1) {
                            q.add(it);
                            color[it] = 0;
                        }
                    }
                    
                }
            }
        }
        return true;

    }

    public static boolean isBipartite(int V, int[][] edges) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfs(i, edges, color)) {
                    return false;
                }
            }

        }
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        // for(int i =  0 ; i< V ; i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int[] edge : edges){
        //     int u = edge[0];
        //     int v = edge[1];
        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        
        // }
        return true;

    }

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = {{1,2, 3}, {0, 2}, {0,1, 3}, {0, 2}};

        System.out.println(isBipartite(V, edges));
    }
}
