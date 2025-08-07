public class binary_subarray_sum_930 {

    // this solution is only valid when goal != 0
    public static int sub_array_sum(int [] arr , int goal){
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum =0;
        int count = 0;
        while(right < n){
            sum +=arr[right];
            if(sum > goal){
                sum -= arr[left];
                if(sum == goal){
                    count++;
                }
                left++;
            }
            if(sum == goal){
                count++;
            }
            right++;
        }
        return count;
    }


    public static int helper_sub(int[] nums , int goal){
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        int count = 0;

        if(goal < 0){
            return 0;
        }

        while(right < n){

            sum += nums[right];
            while(sum > goal && left < n){
                sum-=nums[left];
                left++;
            }
            count += (right - left +1);
            right++;
        }
        return count;
    }
    public static int sub_array_Sum(int [] nums , int goal){
        int result = helper_sub(nums, goal)- helper_sub(nums, goal-1);
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,0,1,0,1};
        int goal = 2;
        //System.out.println(sub_array_sum(arr, goal));
        System.out.println(sub_array_Sum(arr, goal));
    }
}
