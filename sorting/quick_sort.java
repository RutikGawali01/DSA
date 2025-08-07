public class quick_sort {
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

    public static void main(String[] args) {
        int[] arr = {4,6,2,3,7};
        int ans[]  = Quick_sort(arr, 0, arr.length-1);

        for(int i = 0; i< arr.length ; i++){
            System.out.println(ans[i]);
        }
    }
}
