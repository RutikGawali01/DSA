public  class  NextPermutation{
    // given an array find the next permuatation arrangement  which is  greater than array 

    // brute force -  TC - O(n! * n) for factorial and other for linear search -- this cause lot of  time - so not effiecent
    // 1 . find all possible permutation in sorted order 
    // 2 . linear search for given array arangement
    //3 . next index permutation 

    // optimal - 
    // 1. larger prefix match - a[i]< a[i+1] find break point where greater ele is availabe in right side and store in index = i;
    // 2. ele greater than a[ind] but smallest from all remaining so that we can get closer greater arrangement  and swap them 
    // 3 . place remain in  sorted order

    public static void reverse(int[] arr , int i , int j){
        while(i< j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }


    public static int[] next_Permutation(int[] arr){
        int n = arr.length;
        int ind = -1;
        for(int i = n-2 ; i>= 0; i--){
            if(arr[i]< arr[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1){
            reverse(arr, 0, n-1);
            return arr;
        }
        for(int i = n-1;i>ind;i-- ){
            if(arr[i]> arr[ind]){
                int temp = arr[i];
                arr[i]= arr[ind];
                arr[ind] = temp;
                break;
            }
        }
        reverse(arr, ind+1, n-1);
        
        return  arr;
    }

    public static void main(String[] args) {
        //int [] arr = {2, 1, 5, 4, 3, 0, 0};
        int[] arr = {1,3 ,2};

        //reverse(arr, 0, arr.length-1);
        arr = next_Permutation(arr);
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + "-");
        }
    }
}
