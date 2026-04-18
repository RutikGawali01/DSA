
import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {

        String words[] = {"baa", "abcd", "abca", "cab", "cad"};

        System.out.println(findOrder(words));

    }

    public static ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] indegree = new int[V];

        for (int i = 0; i < adj.size(); i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
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

    public static String findOrder(String[] words) {
        int N = words.length;

        Set<Character> set = new HashSet<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                set.add(ch);
            }
        }

        int K = set.size();

        Map<Character , Integer> map = new HashMap<>();
        Map<Integer , Character> revmap  = new HashMap<>();

        int index = 0 ;
        for(Character ch : set){
            map.put(ch, index);
            revmap.put(index, ch);
            index++;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            if(s1.length() > s2.length() && s1.startsWith(s2)){
                return "";
            }
            
            int min = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < min; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    int u = map.get(s1.charAt(ptr));
                    int v = map.get(s2.charAt(ptr));
                    adj.get(u).add(v);
                    break;
                }
            }
        }


        ArrayList<Integer> topo = topoSort(K, adj);

        if(topo.size() != K) return "";

        StringBuilder ans = new StringBuilder();

        for (Integer it : topo) {
            ans.append(revmap.get(it));

        }

        return ans.toString();

    }


}
