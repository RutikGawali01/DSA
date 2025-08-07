public class rotated_k_places {
    public static String reverse(String s , int i , int j){
        StringBuilder sb = new StringBuilder(s);

        while(i<=j){
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, c);
            i++;
            j--;
        }
        return sb.toString();
    }
    public static boolean reversekplaces(String str1 , String str2){
        String temp = str1;
        int n = str1.length();
        
        temp = reverse(temp, 0, 1);
        temp = reverse(temp, 2, n-1);
         temp= reverse(temp, 0, n-1);
        if(temp.equals(str2)){ 
            return true;
        }
       str1 = reverse(str1, 0, n-1);
         str1= reverse(str1, 0, 1);
         str1 = reverse(str1, 2, n-1);
        if(str1.equals(str2)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String str1 ="amazon";
        String str2 = "onamaz";
        
        if(reversekplaces(str1, str2)){
            System.out.println("true");
        }    }
}
