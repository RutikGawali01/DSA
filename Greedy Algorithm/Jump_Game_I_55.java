public class Jump_Game_I_55{
    // leetcode 55
    public static boolean JumpGame(int [] nums){
        int n = nums.length;
        int maxInd = 0;
        for(int i = 0; i<n; i++){
            if(i > maxInd){
                return false;
            }
            maxInd = Math.max(maxInd, (i+nums[i]));
        }
        return true;

    }

    public static void main(String[] args) {
        int[] nums  = {2,3,1,1,4};
        System.out.println(JumpGame(nums));
    }
}