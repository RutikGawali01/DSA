public class ith_bit{
    // check if the ith bit is set or not
    public static  boolean is_ith_bit_set(int n , int i){
        // using left shift
        /*if(( (n & (1 << i) ) != 0 )){
            return true;
        }else{
            return false;
        }*/

        // using right shift
        if( ( ( n>> i) & 1) != 0){
            return true;
        }else{
            return false;
        }
    }

    //set ith bit
    public static int set_ith_bit(int n , int i){
        return (n | (1<<i));
    }

    // clear ith bit
    public static int clear_ith_bit(int n , int i){
        return (n & (~(1<<i)));
    } 

    // toggle the ith bit
    public static int toggle_ith_bit(int n , int i){
        return (n^(1<<i));
    }
    
    //REmove the last set bit(i.e. right most bit)
    public static int remove_last_set_bit(int n){
        return n&(n-1);
    }

    // leetcode 231
    public static boolean number_is_power_of_2(int n){
        if( ( ( n & (n-1) ) == 0 )){
            return true;
        }
        return false;
    }

    

    
    public static void main(String[] args) {
        // right shift(>>) ->  num >> k = num/2^k
        //  left shift(<<) ->  num << k = num*2^k
        /*System.out.println("left shift :" + (2<<1));
         //4

        System.out.println("right shift : " + (4>>1));//2
        */

        System.out.println(is_ith_bit_set(13 , 1));
        System.out.println(set_ith_bit(9, 2));

        System.out.println(clear_ith_bit(13, 2));


        System.out.println(toggle_ith_bit(13, 2));

        System.out.println(remove_last_set_bit(13));

        System.out.println(number_is_power_of_2(16));
        

        
    }
}