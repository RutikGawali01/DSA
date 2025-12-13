

public class checkSorted{
    public static boolean isSorted(int[] arr){
        for(int i = 1 ; i<arr.length ; i++){
            if(arr[i]< arr[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
         int arr[] = {1 , 3, 4 , 90};
         System.out.println(isSorted(arr));   
    }
}
