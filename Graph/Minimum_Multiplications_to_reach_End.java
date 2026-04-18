
import java.util.*;

public class Minimum_Multiplications_to_reach_End {

    static class Pair {

        int steps;
        int node;

        public Pair(int steps, int node) {
            this.steps = steps;
            this.node = node;
        }
    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) return 0; 
        int mod = 100000;
        Queue<Pair> q = new LinkedList<Pair>();

        q.add(new Pair(0, start));

        int dist[] = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();;
            int currstep = p.steps;
            int currstart = p.node;

            

            for (int i = 0; i < arr.length; i++) {

                int newStart = ( currstart * arr[i] ) % mod;
               
                if (currstep + 1 < dist[newStart]) {
                    dist[newStart] = currstep + 1;
                    if(newStart == end) return  currstep + 1;
                     q.add(new Pair( currstep + 1 , newStart));
                }

                // System.out.println("reached here---");
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 7};

        int start = 3, end = 30;

        System.out.println(minimumMultiplications(arr , start , end));
    }
}
