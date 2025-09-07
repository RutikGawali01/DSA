public class Single_number_136{

    // leetcode 136
    public static int single_number(int[] nums){
        int n = nums.length;
        int xor = 0;
        for(int i = 0; i < n ; i++){
            xor = xor^nums[i];
        }
        return xor;
    }
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(single_number(nums));
    }
}