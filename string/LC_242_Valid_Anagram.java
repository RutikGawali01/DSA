public class LC_242_Valid_Anagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length() != t.length()) return false;

            int[] s_char = new int[26];


            for(int i= 0 ; i<s.length() ; i++){
                s_char[s.charAt(i)-'a']++;
                s_char[t.charAt(i)-'a']--;
            }

            // for(int i = 0 ; i< 26  ; i++){
            //     if(t_char[i] != s_char[i] ) return false;

            // }

            for(int cnt : s_char){
                if(cnt !=  0) return false;
            }

            return true;
        }
    }
}
