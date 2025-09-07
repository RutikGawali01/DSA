public class swap_number_using_xor{

    public static void main(String[] args) {
        int a = 5;
        int b = 9;
         
        a = a^b;  // => 
        b = a^b;    // => (a^b)^b => a
        a = a^b;    //=> (a^b)^a => b
        System.out.println(a);
        System.out.println(b);
    }
}