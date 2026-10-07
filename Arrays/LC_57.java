import  java.util.*;

public class LC_57{
    public static  void insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();

        // res.add(intervals[0]);
        for(int i = 0 ; i< n ; i++){
            // int prev_start = res.get(res.size()-1)[0];
            // int prev_end = res.get(res.size()-1)[1];

            // newInterval is in between prev and curr interval
            // new_start > curr_end
            if(newInterval[0] > intervals[i][1]){
                res.add(intervals[i]);
            }else if(newInterval[0] > intervals[i][0]){
                // overlap - merge

                res.add( new int[]{ Math.min(newInterval[0] , intervals[i][0]) , 
                                    Math.max(newInterval[1] , intervals[i][1] ) } 
                        );
            }else{
                res.add(newInterval);
                res.add(intervals[i]);
            }


        }
        System.out.println(res);
    }

    public static void main(String[] args){
         int[][] intervals = {{1,2},{3,5},{6,7} , {8,10} , {12,16} };
         int[] newInterval = {4,8};

         insert(intervals , newInterval);


    }   
}