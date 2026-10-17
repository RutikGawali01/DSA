import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
    char ch;
    int freq;;
    int lastpos;

    public Pair(char ch, int freq, int lastpos) {
        this.ch = ch;
        this.freq = freq;
        this.lastpos = lastpos;
    }

}
public class LC_621_Task_Scheduler {


    public static int leastInterval11(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;

        // map to count freq of each task
        // TC - O( N - Tasks.length)
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // {char , freq , last occ of char }- m
        // max heap on basis of freq
        //   initally last pos - as -1 - no task is executed
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

        //  O(k ) = k total distinct tasks
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue(), -1));
        }

        // for  pq - O(K.log(K)
        StringBuilder sb = new StringBuilder();

        //

        while (!pq.isEmpty()) {

            PriorityQueue<Pair> temp = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));

            Pair executed = null;

            // keeps extracting tasks until it finds an eligible  tasks
            while (!pq.isEmpty()) {
                Pair top = pq.poll();
                if ((top.lastpos == -1) || (top.lastpos + n < sb.length())) {
                    executed = top;
                    break;
                }
                temp.add(top);
            }

            while (!temp.isEmpty()) {
                pq.add(temp.poll());
            }

            if (executed == null) {
                sb.append('#');
                continue;
            }

            sb.append(executed.ch);
            if (executed.freq - 1 != 0) {
                pq.add(new Pair(executed.ch, executed.freq - 1, sb.length() - 1));
            }
        }
        return sb.length();
    }



    public static int leastInterval(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;

        int[] freq = new int[26];
        int maxfreq = -1; // max freq of char
        for(char ch : tasks){
            freq[ch-'A']++;
            maxfreq = Math.max(maxfreq , freq[ch-'A']);
        }


        int maxcount = 0; // no of  char equals to the max freq =
        for(int i  = 0 ; i< 26  ; i++){
            if(freq[i]  == maxfreq ){
                maxcount++;
            }
        }

        //  no of  gaps betwn most freq  task
        int partitions = maxfreq -1; // 2


        // emptyslots -
        // ["A","A","A", "B","B","B"], n = 3 maxfreq - 3  - maxcount - 2
        // initalliy - [A - - - A - - - A ] but here  maxcount - 2 - (B - 3)
        //  [A B - - A B - - A B ] -
        // empty slots represents total available slots after considering all the max freq  tasks
        int emptyslots  = partitions * (n-(maxcount-1)); /// 4

        //  tasks remaming after  considering all the maxfreq tasks
        int availabletasks  = tasks.length-(maxcount*maxfreq); // 0

        //    idle  tasks that  should  be added
        int idletasks =  Math.max(0  , emptyslots-availabletasks);



        return tasks.length+idletasks;
    }

    public static void main(String[] args) {
        char[] tasks = {'A','B','C','D','E','A','B','C','D','E'};

        int n = 4;

        System.out.println(leastInterval(tasks , n));

    }
}