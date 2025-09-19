import java.util.Arrays;
public class Shortest_Job_first_gfg{
    // shortest job first or SFG  CPU Scheduling
    public static int sfg(int[] bt){
        Arrays.sort(bt);
        int n = bt.length;
        int t = 0;
        int wt = 0;
        for(int i = 0 ; i<n ; i++){
            wt += t;
            t += bt[i];
        }
        return wt/n;
    }

    public static void main(String[] args) {
        int bt[] = {4,3,7,1,2};
        System.out.println(sfg(bt));
    }
}   