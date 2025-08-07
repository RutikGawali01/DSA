import java.util.Stack;

public class next_greater_element {
    /*  public static int[] nge(int[] arr){
        int n = arr.length;
        int [] nge = new int[n];
        Arrays.fill(nge , -1);
        for(int i = 0; i< n ; i++){
            for(int j = i+1 ; j< n ; j++){
                if(arr[j] > arr[i]){
                nge[i] = arr[j];
                break;
                }
            }
        }
    return nge;
    }*/
    
    public static int [] nge_2(int[] arr){
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];
        for(int i = arr.length -1 ; i >= 0 ; i--){
            while(!st.isEmpty() && st.peek()<= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {6,0 , 8 , 1,3};
        
        // int ans[] = nge(arr);
        
        int ans[] = nge_2(arr);
        for(int i = 0 ; i< arr.length ; i++){
            System.out.print(ans[i] +  " ");
        }
   } 
}


// for leetcode 496 
/*
        class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Step 1: Find next greater for all elements in nums2
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        // Step 2: For each element in nums1, find its index in nums2 and use precomputed nge
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = nge[j];
                    break;
                }
            }
        }

        return result;
    }
}


 */