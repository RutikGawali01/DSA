
import java.util.*;

public class EventualSafeStates_BFS_TopoSort {

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adjRev.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];


        for (int i = 0; i < graph.length; i++) {
            // i --> it
            // it --> it 
            for (Integer it : graph[i]) {
                adjRev.get(it).add(i);;
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0  ; i < indegree.length ; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        } 

        ArrayList<Integer> ans  = new ArrayList<>();

        
        while(!q.isEmpty()){
            int node  = q.poll();
            ans.add(node);

            for(Integer it : adjRev.get(node)){
                indegree[it]--;

                if(indegree[it] == 0 ){
                    q.add(it);
                }
            }
        }
    

        int[] res = new int[ans.size()];
        for(int i =  0  ; i< ans.size() ; i++){
            res[i] = ans.get(i);
        }
        
          Collections.sort(ans); 

          return  ans;

    }

    public static void main(String[] args) {

    }
}
