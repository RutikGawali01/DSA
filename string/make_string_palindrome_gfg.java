public class make_string_palindrome_gfg {
    public static String reverse(String str){
        int i = str.length()-1;
        String res = "";
        while(i >= 0){
            res+=str.charAt(i);
            i--;
        }
        return res;
    }

    public static int lps(String str){
        int n = str.length();
        int []freq = new int[n];
        int pre = 0;
        int suf = 1;
        while(suf < n){
            if(str.charAt(pre) == str.charAt(suf)){
                freq[suf] = pre +1;
                pre++;
                suf++;
            }else{
                if(pre == 0){
                    freq[suf] = 0;
                    suf++;
                }else{
                    pre = freq[pre-1];
                }
            }
        }
        return freq[n-1];
    }

    public static int make_palindrome(String str1){
        int n = str1.length();
        String str2 = reverse(str1);
        str1+='#';
        str1 +=str2;
        int ans = lps(str1);
        return n-ans;
    }
    public static void main(String[] args) {
        String str = "geeks";
        System.out.println(make_palindrome(str));

    }
    
}
