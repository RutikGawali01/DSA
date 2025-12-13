public class secondLargest{

    // simple approach --> find largest , update largest in array as -1 and again find largest element .

    // best approach ->
    // TC -O(n)
    public static int slarge(int [] arr){
        int large = arr[0];
        int secondLarge = Integer.MIN_VALUE;
        for(int i = 0 ; i< arr.length ; i++){
            if(arr[i]> large){
                secondLarge = large;
                large = arr[i];
            }else if(arr[i]< large && arr[i] > secondLarge){
                secondLarge = arr[i];
            }
        }
        return secondLarge;

    }
    public static void main(String[] args) {
        int arr[] = {1 , 3, 90 , 4};
        System.out.println(slarge(arr));
    }
}