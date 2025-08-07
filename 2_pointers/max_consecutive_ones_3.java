public class max_consecutive_ones_3 {

    public static int max_ones(int [] arr , int k){
        int left = 0;
        int right = 0;
        // int count0 = 0;
        int n = arr.length;
        int max_count = 0;
        int len =0;
        for(int i = 0 ; i< n ; i++){
            int count0 = 0;
            for(int j =  i ; j < n ;j++){
                if(arr[j] == 0){
                    count0++;
                }
                if(count0 <= k){
                    len = j - i +1;
                    max_count = Math.max(len , max_count);

                }else{
                    break;
                }

            }
        }
        return max_count;
    }
  
    public static int max_con_ones(int[] arr , int k){
        int left = 0;
        int right = 0;
        int zeros = 0;
        int max_len = 0;
        int len = 0;

        int n = arr.length;
        while(right < n){
            if(arr[right] == 0){
                zeros++;
            }
            if(zeros > k){
                if(arr[left] == 0){
                    zeros--;
                }
                left++;
            }
            if(zeros <= k){
                len = right-left+1;
                max_len = Math.max(len , max_len);

            }
            right++;
        }
        return max_len;

    }
    
    
    public static int maxx_one(int [] arr , int k ){
        int left = 0;
        int right = 0;
        int len = 0;
        int max_len = 0;
        int zeros = 0;

        int n = arr.length;
        while(right < n ){
            if(arr[right] == 0){
                zeros++;
            }
            while(zeros > k){
                if(arr[left] == 0){
                    zeros--;
                }
                left++;
                if(zeros <= k){
                    len = right - left +1;
                    max_len = Math.max(len , max_len);
                }
            }
            right++;
        }
        return max_len;
    }
    public static void main(String[] args) {
        int []nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(max_ones(nums, k));
        System.out.println(max_con_ones(nums, k));
        System.out.println(maxx_one(nums, k));
    }
}
