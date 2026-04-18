
import java.util.HashSet;

public  class  LongestConsecutiveSeq{
    // given an array -- return length of longest consecutive seq.

    // brute force -- 
    // pick  up every ele -- check if its next is present in array or not -- if present - increase cnt;
    public static boolean linearSearch(int[] arr, int num){
        for(int i = 0 ; i<arr.length ; i++){
            if(arr[i] == num){
                return  true;
            }
        }
        return false;
    }
    
    public static int longestSeq(int[] arr){
        int cnt = 0;
        int longest = 1;

        for(int i = 0; i<arr.length ; i++){
            int x = arr[i];
            cnt = 1;
            while(linearSearch(arr, x+1) == true){
                x++;
                cnt++;
            }
            longest = Math.max(cnt, longest);
        }
        return  longest;

    }


    // better solution --sorting must  -TC -O(n)+O(n.logn) for sorting 
    //check a[i]-1 with lastsmall --- if equal increase cnt++ ans update lastsmall
    // if ele == lastSmall - start new seq with cnt = 1
    public static int longestConsSeq(int[] arr){
        int longest = 1;
        int cnt = 0;
        int lastSmall = Integer.MIN_VALUE;

        for(int i = 0;i< arr.length ; i++){
            if(arr[i]-1 == lastSmall){
               cnt++;
               lastSmall = arr[i];
            }else if(arr[i] != lastSmall ){
                cnt = 1;
                lastSmall = arr[i];
            }else{
                // a[i] == lastsmall -- means repeated elements in this seq
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }


    // optimal solution using set - hashsset 

    public static int longest_Subsequence(int[] arr){
        int n = arr.length;
        if(n == 0 ) return 0;

        int longest = 1;
        HashSet<Integer> st = new HashSet();
        for(int i = 0;i< n ; i++){
            st.add(arr[i]);
        }
        for(Integer it:st){
            if(!st.contains(it-1)){
                int cnt =1;
                int x = it;
                while(st.contains(x+1)){
                    cnt++;
                    x++;
                }
                longest = Math.max(cnt, longest);
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        int [] arr = {1 , 1, 2, 3, 4, 5,100, 101, 102, 103, 104, 105};
        System.out.println(longestConsSeq(arr));
        System.err.println(longest_Subsequence(arr));
         
    }
}