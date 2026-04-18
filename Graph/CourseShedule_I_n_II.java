public class CourseShedule_I_n_II{

    //course scheduke I 
    public boolean isCyclic(int V, int[][] edges) {
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
            return false; // valid topo sort  present   with v vertexes
        }
        return  true; // cycle present  

    
    
    }
    

    public boolean canFinish(int numCourses, int[][] prerequisites) {
         if(isCyclic(numCourses , prerequisites)){
            return false;
        }
        return true; // cycle not present  - valid topo sort exists 
    }


    // course schedule - II
    
// leetcode 


    public static void main(String[] args) {
        
    }
}
