public class longest_prefix_suffix {
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
    public static void main(String[] args) {
        String str = "ABCABDABCABCABD";
        System.out.println(lps(str));
    }
}
