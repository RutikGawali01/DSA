
public class ReverseWords_inString_151 {

    // public static String reverseWords(String s) {
    // "__hello___world__"
    //    String trim = s.trim(); // after trim -> "hello___word" -> removes first nd last spaces
    //    String[] arr = trim.split("\\s+"); // -> after split - [hello,word]
    //    int i = 0;
    //    int  j = arr.length-1;
    //    while(i< j){
    //         String temp = arr[i];
    //         arr[i] = arr[j];
    //         arr[j] = temp;
    //         i++;
    //         j--;
    //    }
    //    // after reverse - [word, hello];
    //    String res = String.join(" ", arr);  // after join - word hello
    //    return res;
    // }
    public static String reverseString(String str, int i, int j) {

        StringBuilder sb = new StringBuilder(str);

        while (i < j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }

        return sb.toString();
    }

    public static String reverseWords(String s) {
        int l = 0;
        int r = s.length() - 1;

        // this loop removes start and end spaces - 
        while (l < r) {
            if (s.charAt(l) == '_') {
                l++;
            } else if (s.charAt(r) == '_') {
                r--;
            } else {
                break;
            }
        }
        String temp = s.substring(l, r + 1);

        StringBuilder sb = new StringBuilder();
        // add char after removing middle spaces if more than 1
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '_') {
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '_') {
                    continue;
                } else {
                    sb.append(temp.charAt(i));
                }
            } else {
                sb.append(temp.charAt(i));
            }
        }

        // System.out.println(sb);
        String str = reverseString(sb.toString(), 0, sb.length() - 1);

        System.out.println(str);

        int i = 0;
        int j = 0;
        StringBuilder builder = new StringBuilder();

        while (j < str.length()) {
            if (str.charAt(j) != '_') {
                j++;

            } else {
                // System.out.println("res");
                String tem = reverseString(str.substring(i, j), 0, j - i - 1);
                builder.append(tem + "_");
                j++;
                i = j;
            }
        }
        String tem = reverseString(str.substring(i), 0, str.length() - i - 1);
        builder.append(tem);

        return builder.toString();

    }

    public static void main(String[] args) {

        String s = "__hello__world___";
        // int l  = 0;
        // int r = s.length()-1;

        // // this loop removes start and end spaces - 
        // while(l< r){
        //     if(s.charAt(l) == '_'){
        //         l++;
        //     }else if(s.charAt(r) == '_'){
        //         r--;
        //     }else{
        //         break;
        //     }
        // }
        // String temp = s.substring(l,r+1); 
        System.out.println(reverseWords(s));
        // System.out.println(temp);

    }

}
