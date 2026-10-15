public  class LC_436_Find_Right_Interval  {

    /*TC - O(n^2 . log n ) - got TLE */
    public static int[] findRightInterval1(int[][] intervals) {
        int[] res = new int[intervals.length];

        Arrays.fill(res, -1);

        // max heap acc to start time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int i = 0;
        for (int[] interval : intervals) {
            pq.add(new int[] { interval[0], interval[1], i++ });
        }

        i = 0;
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            PriorityQueue<int[]> temp  = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

            while( !pq.isEmpty() && pq.peek()[0] >= end ){
                int[] top = pq.poll();
                temp.add(top);
                // if(top[0] >= end){
                res[i] = top[2];
                // }
            }
            i++;


            while(!temp.isEmpty()){
                pq.add(temp.poll());
            }
            // for (int[] top : pq) {
            //     // start_j
            //     if (top[0] >= end) {
            //         res[i] = top[2];
            //     } else {
            //        break;
            //     }
            // }

        }
        return res;

    }

    //    TC - n * Log(n) and sc - O(n)
    public static int[] findRightInterval(int[][] intervals) {
        // sort given array in asc order- TC - log n

        // after sorting index will be changes - so keep track of ind with start ele - and in sorted we did not required end time -
        int[][] sorted = new int[intervals.length][2];
        for(int i = 0 ;i <  intervals.length ; i++){
            sorted[i][0] = intervals[i][0]; // start timme
            sorted[i][1] = i; //  index
        }
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[intervals.length];

        Arrays.fill(res , -1);
        for(int i = 0 ; i < intervals.length ; i++){
            int[] interval = intervals[i];
            int end = interval[1];
            int left = 0 ;
            int right  = sorted.length -1;
//            int mid = (left+right)/2;
            while(left <= right){
                int  mid = (left  + right )/2;
                if(sorted[mid][0] >= end){
                    res[i]  = sorted[mid][1];
                    right = mid-1;
                }else{
                    left = mid+1;
                }



            }

            System.out.println(res[i]);

        }
        return res;
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{0,1},{3,4}};
        System.out.println(findRightInterval(intervals));

    }
}