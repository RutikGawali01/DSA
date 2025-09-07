public class divide_two_int{

    public static int divide_two_int_without_multiplicationAndDivision(Long dividend , Long divisor){
        if(dividend == divisor){
            return 1;
        }
        boolean sign = true;//+ve
        if(dividend >= 0 && divisor<0){
            sign = false;//-ve 
        }else if(dividend < 0 && divisor >0){
            sign = false;
        }
        Long n = Math.abs(dividend);//convert to +ve number
        Long d = Math.abs(divisor);
        int ans = 0;
        while(n>=d){
            int count = 0;
            // ( d<<count+1)  == d*(2^(count+1))
            while( n > ( d<<count+1) ){
                count++;
            }
            n = n - (d<<count);
            ans += (1<<count);// 2^count
        }

        if(ans >= (1<<31) && sign == true){
            return (Integer.MAX_VALUE);
        }
        if(ans >= (1<<31) && sign == false){
            return Integer.MIN_VALUE;
        }
        return sign == true ? ans : -ans;
    }

    public static void main(String[] args) {
        int ans = divide_two_int_without_multiplicationAndDivision(22l, 3l);
        System.out.println(ans);
        
    }
}