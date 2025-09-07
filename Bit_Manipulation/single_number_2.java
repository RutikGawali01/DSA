public class single_number_2{

    // every number is appearing thrice , expect one number which is appearing single time. -> return that number;
    // time  complexity = O(32)*O(n)
    // space complexity = O(1)
    public static int single_number_2(int[] nums){
        int ans = 0;
        int n = nums.length;
        for(int bitIndex = 0 ; bitIndex < 32; bitIndex++){
            int count = 0;
            for(int i = 0; i< n ; i++){
                if((nums[i] & (1<< bitIndex)) != 0){ // check if the ith bit is set or not
                    count++;
                }
            }
            if(count%3 == 1){
                ans = ( ans | ( 1 << bitIndex) ); // set ith bit
            }
        }

        return ans;
    }


    // quick sort is is used for sorting nums in below solution
public static int partition(int [] arr , int low , int high ){
        int i = low; 
        int j = high;
        int pivot = arr[low];
        while(i< j){
            while(arr[i] <= pivot && i <= high-1){
                i++;
            }
            while(arr[j] > pivot && j >= low+1){
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        

        return j;

    }  
    public static void qs(int [] arr  , int low , int high){
        if(low < high){
            int partInd = partition(arr, low, high);
            qs(arr, partInd+1, high);
            qs(arr, low, partInd-1);

        }
    } 
    public static int[] Quick_sort(int [] arr , int low , int high){
        int n = arr.length;
        qs(arr, 0 , n-1);
        return arr;

    }


    // time complexity = O(nlog(n)) + O(n/3)
    // space complexity = O(1)
    public static int SingleNumber(int[] nums){
        int n = nums.length;
        Quick_sort(nums, 0, n);
        for(int i = 1 ; i< n ; i = i+3){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }
        return nums[n-1];
    }



    // most optimal with time complexity O(n) and space complexity O(1)
    public static int optimal_single_number_2(int[] nums){
        int ones = 0;
        int twos = 0;
        int n = nums.length;
        for(int i = 0 ; i< n ;  i++){
            ones = (ones ^ nums[i]) & (~twos);
            twos = (twos ^ nums[i]) & (~ones);
        }
        return ones;
    }
 
    public static void main(String[] args) {
        int[] nums = {5,5,5,6,4,4,4};
        System.out.println(single_number_2(nums));
        System.out.println(SingleNumber(nums));
        System.out.println(optimal_single_number_2(nums));

    }
}