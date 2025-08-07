import java.util.*;
public class fruits_into_basket_904 {
    // brute force of time complexity of o(n^2);
    public static int fruits_basket(int [] arr , int k){
        int n = arr.length;
        int max_len = 0;
        for(int i = 0; i < n ; i++){
            HashSet<Integer> st =new HashSet<>();
            
            for(int j = i ; j< n ; j++){
                st.add(arr[j]);
                if(st.size() <= k){
                    max_len = Math.max(max_len, j-i+1);
                }else{
                    break;
                }
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        int arr[] = {3,3,3,1,2,1,1,2,3,3,4};
        int k = 2;
        System.out.println(fruits_basket(arr, k));
    }    
}
