public class sort_vowels_in_String {
    public static String sort_vovels(String s){
        StringBuilder str = new StringBuilder(s);
        int upper[] = new int[26];
        int lower[] = new int[26];
        for(int i =0; i<str.length();i++){
            if(str.charAt(i)=='A'|| str.charAt(i)=='E'|| str.charAt(i)=='I' ||str.charAt(i)=='O' || str.charAt(i)=='U'){
                upper[str.charAt(i)-'A']++;
                str.setCharAt(i, '#');
            }else if(str.charAt(i)=='a'|| str.charAt(i)=='e'|| str.charAt(i)=='i' ||str.charAt(i)=='o' || str.charAt(i)=='u'){
                lower[str.charAt(i)-'a']++;
                str.setCharAt(i, '#');
            }
        }
        //upper
        String vowel = "";
        for(int i =0 ;i<26; i++){
            char c = (char)('A'+i);
            while(upper[i]>0){
                vowel+=c;
                upper[i]--;
            }
        }
        //lower
        for(int i = 0 ; i< 26 ; i++){
            char c = (char)('a'+i);
            while(lower[i]>0){
                vowel+=c;
                lower[i]--;
            }
        }
        int v_ind = 0; 
        int s_ind = 0;
        while(v_ind < vowel.length()){
            if(str.charAt(s_ind) == '#'){
            str.setCharAt(s_ind, vowel.charAt(v_ind));
            v_ind++;
            }      
            s_ind++;
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(sort_vovels(s));

    }
}
