

public class sort_string {
    public static String sort_String(String str){
        int[] freq = new int[26];

        for(int i = 0 ;  i<str.length();i++){
            int ind = str.charAt(i)-'a';
            freq[ind]++;

        }
        String ans = "";
        for(int i = 0; i<26; i++){
            char c =  (char)('a' + i) ;
            while(freq[i]>0){
                ans+=c;
                freq[i]--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "edcaaab";
        System.out.println(sort_String(s));

    }
}
