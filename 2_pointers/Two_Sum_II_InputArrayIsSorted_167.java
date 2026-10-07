public class Two_Sum_II_InputArrayIsSorted_167{
    class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 1;
        int j = numbers.length;
        while(i< j ){
            if(numbers[i-1]+numbers[j-1] == target){
                return new int[]{i, j};
            }else if(numbers[i-1]+numbers[j-1] > target ){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}
}