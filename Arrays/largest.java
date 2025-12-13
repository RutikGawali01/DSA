public class largest{

    // another simple approch --> sort array and return last element

    // TC - O(n)
    public static int largestELement(int [] arr){
        int large = -1;
        for(int i  = 0 ; i< arr.length ; i++){
            if(arr[i]>large){
                large = arr[i];
            }
        }
        return large;
    }


    public static void main(String[] args) {
        int arr[] = {1 , 3, 90 , 4};

        System.out.println(largestELement(arr));

    }

}