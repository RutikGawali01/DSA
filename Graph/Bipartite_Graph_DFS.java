
import java.util.*;

public class Bipartite_Graph_DFS {

    public static boolean dfs(int src, int curr, int[][] graph, int[] color) {
        color[src] = curr;
        for (int it : graph[src]) {
            if (color[it] == -1) {
                
                if (dfs(it, 1-curr, graph, color) == false) {
                    return false;
                }
            } else if (color[it] == curr) {
                return false;
            }
        }
        return true;
    }
    

    public static boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color, -1);

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, graph, color) == false) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int edges[][] = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(edges));
    }
}
