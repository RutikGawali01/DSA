public class xor_of_all_number{

    // time complexity = O(n) and space comlexity = O(1)
    // Xor of all numbers from 1 to n
    public static int xor_of_no(int n){
        int ans = 0;
        for(int i = 1 ; i <= n ; i++){
            ans = ans ^ i;
        }
        return ans;
    }

    // time complexity = O(1) and space complexity = O(1)
    // xor of numbers form 1 to n
    public static int xor_of_all_number(int n ){
        if(n%4 == 1){
            return 1;
        }else if(n % 4 == 2){
            return n+1;
        }else if(n % 4 == 3){
            return 0;
        }else{
            return  n;
        }
    }

    // xor of numbers in range between L to R ;
    //time complexity = O(1)
    public static int xor_in_ranges(int L , int R){
        return xor_of_all_number(L-1) ^ xor_of_all_number(R);
    }
    public static void main(String[] args) {
        System.out.println(xor_of_no(2));
        System.out.println(xor_of_all_number(6));
        System.out.println(xor_in_ranges(4, 7));
    }
}