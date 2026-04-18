
import java.util.*;



public class shortestPath_In_DAG{
        static class Pair {
            int v;
            int wt;

            public Pair(int v, int wt) {
                this.v = v;
                this.wt = wt;
            }


        }
    
    public static void dfs(int src , boolean [] vis , ArrayList<ArrayList<Pair>> adj , Stack<Integer> st){
        vis[src] = true;

        for(Pair p : adj.get(src)){
            if(!vis[p.v]){
                dfs(p.v, vis, adj, st);
            }
        }

        st.push(src);
        
    }

    public static int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        // o(V)
        for(int i = 0 ; i< V ; i++){
            adj.add(new ArrayList<>());
        }

        // O(E)
        for(int[] edge : edges){
            int u = edge[0];
            int v= edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
        }
        // adj list - O(V + E)

        boolean[]  vis = new boolean[V];

        Stack<Integer> st = new Stack<>();


// Total DFS cost: - O(V + E)
        for(int i = 0 ; i< V ; i++){
            if(!vis[i]){
                dfs( i , vis , adj, st);
            }
        }

        int[] shortestPath = new int[V];
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
       
        shortestPath[0] = 0;

        // Each node popped once → O(V)
// Each edge relaxed once → O(E)
        //O(V + E) - 
        while(!st.isEmpty()){
            int node = st.pop();
            
            int dist = shortestPath[node];
            // System.out.println("node : " + node + "- " + dist);
            for(Pair p : adj.get(node)){
                int v = p.v;
                int wt = p.wt;

                if (shortestPath[node] != Integer.MAX_VALUE){
                    shortestPath[v] = Math.min(shortestPath[v], dist+wt);
                }

                
                // System.out.println(" v- "+ v + "-" + shortestPath[v]);
            }

        }

        for(int i = 0 ; i < shortestPath.length ; i++ ){
            if(shortestPath[i] == Integer.MAX_VALUE){
                shortestPath[i] = -1;
            }
        }

        return shortestPath;    
    }


    public static void main(String[] args) {
        int V = 10;
        int E = 24;
        int[][] edges = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
        
        
        int ans[] = shortestPath(V, E, edges);

        for(int i = 0 ; i< ans.length; i++){
            System.out.print(ans[i] + "--");
        }
    }
}

// clean code - acc to gpt 
/*  static class Edge {
    int vertex;
    int weight;

    Edge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public static void topoSortDFS(int node, boolean[] visited,
                              ArrayList<ArrayList<Edge>> adj,
                              Deque<Integer> stack) {

    visited[node] = true;

    for (Edge edge : adj.get(node)) {
        if (!visited[edge.vertex]) {
            topoSortDFS(edge.vertex, visited, adj, stack);
        }
    }

    stack.push(node);
}

public static int[] shortestPath(int V, int E, int[][] edges) {

    // Step 1: Build graph
    ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
        adj.get(edge[0]).add(new Edge(edge[1], edge[2]));
    }

    // Step 2: Topological Sort
    boolean[] visited = new boolean[V];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            topoSortDFS(i, visited, adj, stack);
        }
    }

    // Step 3: Shortest Path
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);

    int source = 0;
    dist[source] = 0;

    while (!stack.isEmpty()) {
        int node = stack.pop();

        if (dist[node] != Integer.MAX_VALUE) {
            for (Edge edge : adj.get(node)) {
                int newDist = dist[node] + edge.weight;
                if (newDist < dist[edge.vertex]) {
                    dist[edge.vertex] = newDist;
                }
            }
        }
    }

    // Step 4: Replace unreachable with -1
    for (int i = 0; i < V; i++) {
        if (dist[i] == Integer.MAX_VALUE) {
            dist[i] = -1;
        }
    }

    return dist;
} 
*/