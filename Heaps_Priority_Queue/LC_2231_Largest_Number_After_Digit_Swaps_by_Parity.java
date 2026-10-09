import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC_2231_Largest_Number_After_Digit_Swaps_by_Parity {

//    Brute force solution -
    public static int largestInteger1(int num) {
//        System.out.println(num);
        StringBuilder sb  = new StringBuilder();
        sb.append(Integer.toString(num));

//        System.out.println(sb + "fiho");

        for(int i = 0 ; i< sb.length() ; i++){
            boolean isEven = false;
            int curr = sb.charAt(i)-'0';
//            System.out.println(curr);
            if(curr %2 == 0 ) isEven = true;
            int max = -1;
            int maxind  = -1;

            for(int j = i+1 ; j< sb.length() ; j++){
                // even
                if(isEven && (sb.charAt(j)-'0') %2 == 0 ){
//                    System.out.println(sb.charAt(j)-'0');
                    if(sb.charAt(j)-'0' > max && sb.charAt(j)-'0' > curr){
                        max  = sb.charAt(j)-'0';
                        maxind = j;
                    }
                    // max = Math.max(max , sb.charAt(j)-'0');
                }
                //  odd
                if(!isEven && (sb.charAt(j)-'0') % 2 != 0){
                    if(sb.charAt(j)-'0' > max && sb.charAt(j)-'0' > curr){
                        max  = sb.charAt(j)-'0';
                        maxind = j;
                    }

                }

            }

            if(maxind != -1){
                sb.setCharAt(maxind , sb.charAt(i));
                sb.setCharAt(i ,  Integer.toString(max).charAt(0));

//                System.out.println(sb);
            }

            System.out.println(sb);

        }

        String ans = sb.toString();


            if(ans.length() != 0) {


                return Integer.parseInt(ans);

            }

            return -1;


    }


    public static int largestInteger2(int num) {
        PriorityQueue<Character> even = new PriorityQueue<>(Comparator.reverseOrder());

        PriorityQueue<Character> odd = new PriorityQueue<>(Comparator.reverseOrder());
        char[] arr = Integer.toString(num).toCharArray();
        for(char ele : arr ){
            System.out.println(ele);
            if((int)ele % 2  == 0 ){
                System.out.println("even -- " +  ele);
                even.add(ele);
            }else{
                System.out.println("odd -- " +  ele);
                odd.add(ele);
            }
        }


//        StringBuilder sb = new StringBuilder(Integer.toString(num));

        for(int i  = 0 ; i<arr.length ; i++){
//            even
           if((int)arr[i] % 2 == 0 ){
               arr[i] = even.poll();
           }else{
               arr[i] = odd.poll();
           }
        }
        if(arr.length != 0){
            return Integer.parseInt(new String(arr));
        }
            return -1;




    }


    public static  int largestInteger(int num) {
        int[] freq = new int[10];
        int tmp = num;

        while(tmp > 0){
            int dig = tmp%10;
            freq[dig]++;
            tmp /= 10;
        }
//        StringBuilder sb = new StringBuilder();
        char arr[] = Integer.toString(num).toCharArray();

        for(int i = 0 ; i< arr.length ; i++){
            char ch = arr[i];
            int ind;
            if((ch - '0') % 2 == 0 ){
//                eveen
                 ind  = 8;


            }else{
//                odd
                ind = 9;
            }

            while( ind >= 0 && freq[ind] < 1){
                ind = ind-2;
            }

            arr[i] = (char)(ind+'0');


            if(ind != -1) freq[ind]--;


        }

//        System.out.println(new String(arr));


        if(arr.length != 0) {


            return Integer.parseInt(new String(arr));

        }
        return -1;


    }


    public static void main(String[] args) {
        int num = 65875;
//        System.out.println(largestInteger2(num));

        System.out.println(largestInteger(num));
    }
}
