public  class  minmax{
    public static void merge(int [] arr , int low  , int mid , int high,  int min , int max){
        int left = low, right = mid + 1;
        
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                
            }else {

            }
        }

    }

    public void min_max(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        min_max(arr, low, mid);

        min_max(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        
    }
}