
public class selection_sort {
    public static void main(String[] args) {
        int [] arr = { 2, 9 , 3, 1 };
        int n = arr.length;
        for(int i = 0 ; i< n ;i++){
            int small= i;
            for(int j = i+1 ; j<n; j++){
                if(arr[small] > arr[j]){
                    small = j;
                }
            }
            int temp = arr[small];
            arr[small] = arr[i];
            arr[i] = temp;
        }

        for(int i = 0 ; i< n ; i++){
            System.out.println(arr[i]);
        }
    }
}
