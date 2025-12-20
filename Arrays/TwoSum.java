
import java.util.*;

public class TwoSum{
    // leetcode 1

    // brute force TC- O(N^2)
    public static ArrayList<Integer> twoSumBrute(int[] arr, int target){
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i< arr.length ; i++){
            for(int j = 0 ; j < arr.length ; j++){
                if(arr[i]+ arr[j] == target ){
                    ans.add(i);
                    ans.add(j);
                    return ans;
                    // return true;
                }
            }
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
        //return false;
        
    }
    
    // better solution 
    // using Hashmap  - store element with its index in map 
    // calculate rem = target - arr[i]---- if present return ans
    // TC - O(N) and Sc - O(n)
    public static ArrayList<Integer> twoSumBetter(int [] arr , int target){
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i< arr.length ; i++){
            int rem = target - arr[i];

            if(map.containsKey(rem)){
                ans.add(i);
                int j = map.get(rem);
                ans.add(j);
                return  ans;
            }

            map.put(arr[i], i);
        
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }

    //Only for sorted array's
    // most Optimal 
    //TC - O(n)  and SC - O(1)
    //if we use this solution for returning indexes then we req. more space for storing it with another array with its index
    // 
    public static boolean twoSumOptimal(int[] arr , int target){
        int l = 0; 
        int r = arr.length -1;
        while(l<=r){
            int sum = arr[l]+arr[r];
            if(sum == target){
                return true;
            }else if(sum > target){
                r--;
            }else{
                l++;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        int [] arr = {3,4, 6,8 , 10};
        System.out.println(twoSumBrute(arr, 14));
        System.out.println(twoSumBetter(arr, 14));
        System.out.println(twoSumOptimal(arr, 14));
        
    }

}