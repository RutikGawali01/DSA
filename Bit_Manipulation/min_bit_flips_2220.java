public class min_bit_flips_2220{
    //leetcode 2220
    public static int min_bit_flips_to_convert_no(int start  , int goal ){
        int ans = start^goal;
        int count = 0;
        while(ans != 0){
            ans = ans & (ans-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(min_bit_flips_to_convert_no(10, 7));
    }
}