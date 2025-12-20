public  class  SortZeroOneTwo{

    // brute - using sorting algorithms
    // brute force -- count0 , count 1 , count 2 and then use loopp
    // optimal -- using pointers 

    public static int[] sort012Array(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;

        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, mid, low);
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else {
                swap(arr, mid , high);
                high--;
            }
        }
        return  arr;
    }

    public static int[] swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {0,1, 2, 1, 2 ,1 ,0 , 0 };
        int[] ans = sort012Array(arr);
        for(int i = 0 ; i<arr.length ; i++){
            System.out.println(ans[i]);
        }
        

    }
}