public class Jump_Games_II_45{

    // leetcode 45

    public static int JumpGames2(int [] nums){
        int n = nums.length;
        int jump =0;
        int l =0;
        int r = 0;
        while(r<n-1){
            int farthest = 0;
            for(int ind = l ; ind <= r ; ind++){
                farthest = Math.max(farthest , (ind + nums[ind]));
            }
            l = r+1;
            r = farthest;
            jump = jump +  1;

        }
        return jump;

    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(JumpGames2(nums));
    }
}