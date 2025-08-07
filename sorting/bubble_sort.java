
public class bubble_sort {
    public static void main(String[] args) {
        int [] arr  = { 1, 5, 9,4 };
        int n = arr.length;
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < n -1-i ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; 
                }
            }
        }
        for(int i = 0; i<n ; i++){
            System.out.println(arr[i]);
        }
    }
}
