public class LC_4071{

    // this is  simple brute force - solution -
    // required higher TC =

//  below is optimal logic -

/* 1. Calculate the rotation cost of the original string and store it as ini_rotation.

2. If we reverse suffix [k, n-1], all internal suffix rotations remain the same; only the connection s[k-1] → s[k] is replaced by s[k-1] → s[n-1].

3. So for every k, remove the old edge cost dist(s[k-1], s[k]) and add the new edge cost dist(s[k-1], s[n-1]).

4. Take the minimum cost over all k, including k = 0 (no prefix connection), and return it.

*/



    public static int countRotations(String str) {
        int pointer = 0;

        int total = 0;
        for (int i = 0; i < str.length(); i++) {

            int next = str.charAt(i) - '0';

            if (pointer == next) {
                continue;
            }

            int rotation = Math.min(Math.abs(next - pointer),
                    Math.abs(10 - Math.max(pointer, next) + Math.min(pointer, next)));

            total += rotation;

            pointer = next;

        }

        return total;

    }

    // public static String reverse(String str) {
    //     int i = 0;
    //     int j = str.length() - 1;

    //     StringBuilder sb = new StringBuilder(str);

    //     while (i < j) {
    //         char temp = sb.charAt(i);
    //         sb.setCharAt(i, sb.charAt(j));
    //         sb.setCharAt(j, temp);
    //         i++;
    //         j--;

    //     }

    //     return sb.toString();

    // }

    // public static int minRotations(int n, String s) {
    //     int pointer = 0;
    //     // at most once - either 0 or 1
    //     //

    //     // pre-compute suffix
    //     String[] suffix = new String[n];
    //     for (int i = n - 1; i >= 0; i--) {
    //         suffix[i] = s.substring(i, n);
    //     }

    //     int min = Integer.MAX_VALUE;

    //     min = Math.min(min, countRotations(s));

    //     for (int k = 0; k < n; k++) {

    //         StringBuilder newstr = new StringBuilder();
    //         if (k != 0) {
    //             newstr.append(s.substring(0, k));

    //         }
    //         newstr.append(reverse(suffix[k]));

    //         min = Math.min(min, countRotations(newstr.toString()));

    //     }

    //     return min;

    // }

    public static int minRotations(int n, String s) {
        // key observation - reversing  suffix does not changes rotations
        //  only start rotation is replaced  by end rotation;

        int pointer = 0;
        int min = Integer.MAX_VALUE;
        //  initially calculated total rotations in given String without any operation
        // min = Math.min(min , countRotations(s));
        int ini_rotation = countRotations(s); // initial rotaion in given i/p string
        min = Math.min(min , ini_rotation);
        // our logic - replace  dist bet prev and s[k] with   dist bet prev and s[n-1]


        for (int k = 0; k < n; k++) {
            int curr_dist = ini_rotation;
            if(k == 0){
                pointer  = 0;
            }else{
                pointer = s.charAt(k-1)-'0';
            }

            // remove dist bet prev (pointer) and s[k] -
            int next = s.charAt(k) - '0' ;
            int rotation = Math.min(Math.abs(next - pointer),
                    Math.abs(10 - Math.max(pointer, next) + Math.min(pointer, next)));

            curr_dist -= rotation;
            // add dist bet pointer and s[n-1]( last ele of suffix )
            next = s.charAt(n-1) - '0' ;
            rotation = Math.min(Math.abs(next - pointer),
                    Math.abs(10 - Math.max(pointer, next) + Math.min(pointer, next)));

            curr_dist += rotation;


            min = Math.min(min , curr_dist);


        }

        return min ;
    }

    public static void main(String[] args){

        String s = "2916";

        System.out.println(minRotations(4 , s));

    }


}