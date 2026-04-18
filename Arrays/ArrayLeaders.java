
import java.util.ArrayList;

public  class ArrayLeaders{
    //given array  +ve integers. find all leaders
    // An element is considered a leader if it is greater than or equal to all elements to its right.
    // The rightmost element is always a leader.

    public  static  ArrayList<Integer> reverse(ArrayList<Integer> ans , int i , int j){
        while(i< j){
            int temp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, temp);
            i++;
            j--;
        }
        return ans;
    }

    public static ArrayList<Integer> leaders(int[] arr){
        int n = arr.length;
        int maxi = arr[n-1];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1; i>=0 ; i--){
            if(arr[i]>=maxi){
                maxi = arr[i];
                ans.add(arr[i]);
            }
        }

        return reverse(ans, 0 , ans.size()-1);
    }
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        System.out.println(leaders(arr));
    }
}
