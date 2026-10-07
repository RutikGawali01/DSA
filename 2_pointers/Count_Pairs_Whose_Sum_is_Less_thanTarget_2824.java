public class Count_Pairs_Whose_Sum_is_Less_thanTarget_2824{
    
    class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);

        int n = nums.size();
        int i  = 0;

        int j = n-1;
        int cnt = 0;
        
        while(i< j ){
            if(nums.get(i)+ nums.get(j) >= target){
                j--;
            }else{
                cnt = cnt + (j-i);
                i++;
            }
        }
        return cnt;
    }
}

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int cnt = 0;

        for(int i =  0 ; i< n ;i++){
            for(int j = i+1 ; j < n ; j++){
                if(nums.get(i) + nums.get(j) < target){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

}