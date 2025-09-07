

public class single_number_3{

    //brute force -> using hashmap , counting frequencies of each element and then travesing in map 
    // time complexity of brute force => O(n*log(m) ) + O(m) => m is map size
    
    // optimal solution
    public static int[] single_number_3(int[]  nums){
        int n = nums.length;
        Long xor = 0L;
        for(int i = 0 ; i< n; i++){
            xor =xor^nums[i];
        }
        Long rightmost = (xor&(xor-1))&xor;
        int b1= 0;
        int b2 = 0;
        for(int i = 0; i< n ; i++){
            if((nums[i]&rightmost) != 0){
                b1 = b1^nums[i];
            }else{
                b2 = b2 ^ nums[i];
            }
        }
        return new int[]{b1, b2};

    }

    public static void main(String[] args) {
     int[] nums = {2,4,2,14,8,7,7,8};
     int[] ans = single_number_3(nums);
     for(int i = 0; i< ans.length ; i++){
        System.out.print(ans[i] + " ");
     }   
    }
}