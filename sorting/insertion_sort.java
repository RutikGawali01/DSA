
public class insertion_sort {
    public static void main(String[] args) {
        int [] arr = { 9 , 3 , 4 , 6};
        int n  = arr.length;
        for(int i = 1 ; i< n ; i++){
            int curr = arr[i];
            int j = i-1;
            while(j >=0 && curr < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
  
        for(int i = 0; i< n ; i++){
            System.out.println(arr[i]);
        }
    }
}
