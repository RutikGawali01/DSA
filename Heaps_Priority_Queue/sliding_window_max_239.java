
import java.util.PriorityQueue;

public class sliding_window_max_239{
    // leetcode 239

    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val , int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2){
            //asccending -> return this.val - p2.val
            //descending 
            return p2.val-this.val;
        }
    }

    public static int[] sliding_window_max(int[] nums , int k ){ 
        //time complexity = O(n.logk)
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = nums.length;
        int[] res = new int[n-k+1]; // n-k+1 -> total subarray in array

        for(int i = 0; i<k ; i++){
            pq.add(new Pair(nums[i], i));
        }
        res[0] = pq.peek().val;

        for(int i = k; i<n ; i++){
            while(pq.size()>0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Pair(nums[i], i));
            res[i-k+1] = pq.peek().val;
        }
        return res;

    }

    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int  k = 3;
         int[] res = sliding_window_max(nums, k);

        for(int i = 0; i< res.length ; i++){
            System.out.print(res[i] +",");
        }
    }
}