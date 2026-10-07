public class LC_1004_MaxConsecutiveOnes_III {

    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int  l  = 0;
        int r  = 0;

        int zeros = 0;

        int max = -1;



        while(r<n){

            if(nums[r] == 0) zeros++;

            while(zeros>k){
                if(nums[l] == 0) zeros--;
                l++;
            }

            max = Math.max(max , r-l+1);
            r++;


        }

        return max;
    }



}
