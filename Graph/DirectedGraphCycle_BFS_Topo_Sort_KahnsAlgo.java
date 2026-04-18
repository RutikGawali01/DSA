import java.util.*;

public  class  DirectedGraphCycle_BFS_Topo_Sort_KahnsAlgo{



    public static boolean  topoSort(int V, int[][] edges) {
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
        // ArrayList<Integer> res = new ArrayList<>();
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            // res.add(node);
            count++;
            for (Integer it : adj.get(node)) {
                if (indegree[it] != 0) {
                    indegree[it]--;
                }

                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        if(count == V){
            return false;
        }
        return  true;  

    }



}