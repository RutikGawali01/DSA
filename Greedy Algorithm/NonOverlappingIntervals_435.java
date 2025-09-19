import java.util.Arrays;
public class NonOverlappingIntervals_435{

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[1] , b[1]));   //Arrays.sort sorts this outer array (int[][]) based on the comparator you give it.   
                                            //a[1] = the end time of interval a same for b where a is int[] from array a it pics 2nd ele  i.e end 

        int n = intervals.length;
        int count =  1;
        int freetime  = -1;
        for(int i = 1 ; i<n ;i++){
            if(intervals[i][0] >= freetime){
                count++;
                freetime = intervals[i][1];
            }
        }
        return n-count; 
    }
    public static void main(String[] args) {
        //int[][] intervals = { {1,2}, {2,3}, {3,4}, {1,3} };
         int [][] intervals = {{1,2},{2,3}};
        System.out.println(eraseOverlapIntervals(intervals)); 
    }
}