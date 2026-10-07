public class TUF_415_MaxConsecutiveOnes_II  {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int  l  = 0;
        int r  = 0;

        int zeros = 0;

        int max = -1;



        while(r<n){

            if(nums[r] == 0) zeros++;

            while(zeros>1){
                if(nums[l] == 0) zeros--;
                l++;
            }

            max = Math.max(max , r-l+1);
            r++;


        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,0,1,1,0,0,1,1};

        System.out.println(findMaxConsecutiveOnes(nums));
    }
}