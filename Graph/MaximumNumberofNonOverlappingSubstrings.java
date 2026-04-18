import java.util.*;
public class  MaximumNumberofNonOverlappingSubstrings{

    private static  void dfs1(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs1(v, adj, visited, stack);
            }
        }
        stack.push(u);
    }

    private static  void dfs2(int u, ArrayList<ArrayList<Integer>> adjT, boolean[] visited, List<Integer> component) {
        visited[u] = true;
        component.add(u);
        for (int v : adjT.get(u)) {
            if (!visited[v]) {
                dfs2(v, adjT, visited, component);
            }
        }
    }


    public static List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);  
        
        //  first and last occurrences of each character for - 
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }


        //  Graph creation 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());
        
        boolean[] exists = new boolean[26];
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;
            exists[i] = true;
            
            // Check every character within the range of character i
            for (int k = first[i]; k <= last[i]; k++) {
                int j = s.charAt(k) - 'a';
                // u-u  do not take
                if (i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        // DFS for Finishing Times 
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < 26; i++) {
            if (exists[i] && !visited[i]) {
                dfs1(i, adj, visited, stack);
            }
        }

        // Transpose and Group SCCs  - reverse graph edges - 
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < 26; i++) adjT.add(new ArrayList<>());
        
        for (int i = 0; i < 26; i++) {
            for (int neighbor : adj.get(i)) {
                adjT.get(neighbor).add(i);
            }
        }

        // 
        List<List<Integer>> sccs = new ArrayList<>();
        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                List<Integer> component = new ArrayList<>();
                dfs2(u, adjT, visited, component);
                sccs.add(component);
            }
        }

        //  Map each node to its SCC ID for easy out-degree checking
        int[] nodeToScc = new int[26];
        Arrays.fill(nodeToScc, -1);
        for (int i = 0; i < sccs.size(); i++) {
            for (int node : sccs.get(i)) {
                nodeToScc[node] = i;
            }
        }

            // Extract SCCs with Out-Degree 0 (Sinks)
            List<String> result = new ArrayList<>();
            for (List<Integer> component : sccs) {
                boolean isSink = true;
                for (int u : component) {
                    for (int v : adj.get(u)) {
                        // If an edge points to a node in a DIFFERENT SCC, it's not a sink
                        if (nodeToScc[u] != nodeToScc[v]) {
                            isSink = false;
                            break;
                        }
                    }
                    if (!isSink) break;
                }

                if (isSink) {
                    int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
                    for (int node : component) {
                        start = Math.min(start, first[node]);
                        end = Math.max(end, last[node]);
                    }
                    result.add(s.substring(start, end + 1));
                }
            }

        return result;


    }

    public static void main(String[] args) {
        
    }
}