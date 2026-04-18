
import java.util.*;

public class EventualSafeStates {

    public static boolean dfs(int src, int[][] graph, boolean[] vis, boolean[] pathvis, boolean[] check) {
        vis[src] = true;
        pathvis[src] = true;
        check[src] = false; //

        for (int it : graph[src]) {
            if (!vis[it]) {
                if (dfs(it, graph, vis, pathvis, check)) {
                    check[src] = false; //  this node can not be safe node -- cyle found
                    return true; // if cycle break here
                }
            } else if (pathvis[it]) {
                check[src] = false;//cycle found so this node can not be safe node
                return true; // if cycle break 
            }
        }
        // did not find cycle 
        check[src] = true; // safe node marked 
        pathvis[src] = false;
        return false;

    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean[] vis = new boolean[v];
        boolean[] pathvis = new boolean[v];

        boolean[] check = new boolean[v]; // mark which are the safe nodes
        List<Integer> safenodes = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, graph, vis, pathvis, check);
            }
        }
        for(int i = 0 ; i < v ; i++){
            if(check[i])safenodes.add(i);
        }
        return safenodes;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));

    }
}
