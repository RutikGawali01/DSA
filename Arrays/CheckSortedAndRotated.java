public class  CheckSortedAndRotated{
    // check array is sorted and rotated  --> rotated array is also sorted
    public static boolean  isSortedAndRotated(int [] arr){
        int count = 0;
        for(int i = 0; i< arr.length-1 ; i++){
            if(arr[i] > arr[i+1]){
                count++;
            }
            if(count> 1){
                return false;
            }

        }
        return count == 0 || arr[arr.length-1] <= arr[0];
    }

    public static void main(String[] args) {
        int [] arr ={3 ,4, 5 ,1 ,2};
        System.out.println(isSortedAndRotated(arr));
    }
}