public class count_nice_subarray {

    public static int  helper_nice_subarray(int[] arr, int k ){
        int n = arr.length;
        int left =0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while(right < n){
            sum+= arr[right]%2;
            while(sum > k){
                sum-= arr[left]%2;
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;
    }

    public static int nice_subArray(int[] arr , int k){
        return helper_nice_subarray(arr, k) - helper_nice_subarray(arr, k-1);
    }

    public static void main(String[] args) {
        int [] arr = {1,1,2,1,1};
        int k = 3;
        System.out.println(nice_subArray(arr, k));
    }
}
