
import java.util.ArrayList;
// leetcode 78
public class power_set_78{
    // Time commplexity = n * (2 ^ n);
    // space complexity = approx ((2^n)*n )
        public static ArrayList<ArrayList<Integer>> power_set(int [] nums){
        int n = nums.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int size = 1<<n;
        for(int i = 0 ; i < size ; i++){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int j = 0 ; j < n ;j++){
                if(  (i & (1<<j) ) != 0){
                    ans.add(nums[j]);
                }
            }
            result.add(ans);
        }
        return result;
    }

    public static void main(String[] args) {
       int nums[] = {1,2,3};
        ArrayList<ArrayList<Integer>> temp = power_set(nums);
        
        // for(int i = 0  ; i< temp.size() ; i++){
        //     System.out.println(temp.get(i));
        // }
      System.out.println(temp);

    }
}