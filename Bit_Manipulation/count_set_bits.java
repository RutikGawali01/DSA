public class count_set_bits{

    //without using bitwise operator 
    public static int count_bits(int n ){
        int count = 0;
        while(n>1){
            if(n%2 == 1){
                count++;
            }
            n= n/2;
        }
        if(n == 1){
             return count+1;
        }
        return count;
    }

    public static int count_set_bits(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(count_bits(13));
        System.out.println(count_set_bits(13));
    }
}