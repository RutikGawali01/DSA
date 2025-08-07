public class max_pts_cards_1423 {

    public static int max_cards(int[] arr , int k){
        int left_sum = 0;
        int right_sum = 0;
        int max_sum = 0;
        // for finding sum fromm 1st ele to kth ele 
        for(int i  = 0 ; i< k ; i++){
            left_sum += arr[i];
        }
        
        max_sum = left_sum;
        int right = arr.length -1 ;
        // to remove last element from left part of window
        // remove 1 by 1 elem from end of left part of window
        for(int i = k -1 ; i>= 0 ; i--){
            left_sum = left_sum - arr[i];
            right_sum += arr[right];
            max_sum = Math.max(max_sum , (left_sum + right_sum));
            right--;
        }

        return max_sum;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,1};
        int k = 3;

        System.out.println(max_cards(arr, k));
    }
}
