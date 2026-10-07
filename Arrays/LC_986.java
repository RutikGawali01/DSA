import  java.util.*;
public class LC_986{


    
    public static void intervalIntersection(int[][] firstList, int[][] secondList) {
        // disjoint  - no overlap 
        // close interval -  start , end included
        int n = firstList.length;
        int m = secondList.length;
        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            int first_start = firstList[i][0];
            int first_end = firstList[i][1];
            int sec_start = secondList[j][0];
            int sec_end = secondList[j][1];

            if (first_end >= sec_start && sec_end >= first_start) {
                res.add(Arrays.asList(Math.max(first_start, sec_start), Math.min(first_end, sec_end)));

            }
            if (Math.min(first_end, sec_end) == first_end) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(res);


        // if(res.size() == 0){
        //     return new ArrayList(int[]);
        // }
    }

    public static void main(String[] args){
        System.out.println("hsd ");
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};

        intervalIntersection(firstList, secondList);


    }
}