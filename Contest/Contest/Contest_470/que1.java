public class que1{
    public static  int alternatingSum(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        for(int i = 0; i<n ; i=i+2){
            sum1+= nums[i];
        }
        int sum2 = 0;
        for(int i = 1; i< n ; i= i+2){
            sum2 += nums[i];
        }

        return sum1-sum2;
    }
    public static void main(String[] args) {
        int [] arr = {100};
        System.out.println(alternatingSum(arr));
    }
}