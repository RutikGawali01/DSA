public class longest_palindrome_409 {
    public static int palindrome(String str){
        int lower[] = new int[26];
        int upper[] = new int[26];
        for(int i = 0 ; i<str.length();i++){
            if(str.charAt(i)>='a'){
                lower[str.charAt(i)-'a']++;
            }else{
                upper[str.charAt(i)-'A']++;
            }
        }
        int count = 0;
        int odd =0;
        for(int i =0; i<26; i++){
            if(lower[i]% 2 == 0){
                count+=lower[i];
            }else{
                count += lower[i]-1;
                odd =1;
            }
            if(upper[i]%2==0){
                count+= upper[i];
            }
            else{
                count+= upper[i]-1;
                odd=1;
            }
        }
        return count+odd;
    }
    public static void main(String[] args) {
        String s = "a";
        System.out.println(palindrome(s));
    }
}
