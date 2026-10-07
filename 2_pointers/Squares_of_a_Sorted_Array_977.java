public class  Squares_of_a_Sorted_Array_977{


    class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1;
        int[] temp = new int[n];
        if (n == 1) {
            return new int[] { Math.abs(nums[0]) * Math.abs(nums[0]) };
        }
        // find break point - when +ve ele starts
        while (Math.abs(nums[i]) >= Math.abs(nums[j])) {
            i++;
            j++;

            if (j >= n)
                break; // break when  j goes out of bound
        }
        if (i > 0)
            i = i - 1;
        if (j > 1)
            j = j - 1;

        int ind = 0;
        while (i >= 0 && j < n) {
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                temp[ind] = Math.abs(nums[i]) * Math.abs(nums[i]);
                ind++;
                i--;
                ;
            } else {
                temp[ind] = Math.abs(nums[j]) * Math.abs(nums[j]);
                ind++;
                j++;
            }
        }
        //  traverse rem elements
        while (i >= 0) {
            temp[ind] = Math.abs(nums[i]) * Math.abs(nums[i]);
            ind++;
            i--;
        }
        while (j < n) {
            temp[ind] = Math.abs(nums[j]) * Math.abs(nums[j]);
            ind++;
            j++;
        }

        return temp;
    }
}


    public static void main(String[] args) {
        
    }
}