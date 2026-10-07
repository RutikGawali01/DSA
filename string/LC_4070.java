public class LC_4070{
    public  static int minRotations(String s) {
        // You have a circular dial containing digits 0 to 9: 
        //  initially at  - 0
        //  

        int pointer = 0;
        
        int total = 0;
        for(int i = 0  ; i< s.length() ; i++){

            int next = s.charAt(i) - '0' ;

            


            if(pointer  == next){
                continue;
            }
            
        
             int rotation  = Math.min(   Math.abs(next - pointer ) ,  Math.abs( 10 - Math.max(pointer, next ) + Math.min(pointer , next) ) );
            System.out.println(rotation);
            

            total += rotation ;
            System.out.println(total);
            pointer = next;


        }

        return total;
    }

    public static void main(String[] args){
        String s = "0192837465";
        minRotations(s);

    }
}