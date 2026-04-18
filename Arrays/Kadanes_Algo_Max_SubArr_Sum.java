public class  Kadanes_Algo_Max_SubArr_Sum {
// kadane's algo - for subarray with maximum sum 

    public static int kadanes(int[] arr){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i< n ; i++){
            sum += arr[i];
            if(sum > maxi){
                maxi = sum;
            }
            if(sum < 0) sum =0;
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1 , -2, 1, 5, -3};
        System.out.println(kadanes(arr));
        
    }
    
}