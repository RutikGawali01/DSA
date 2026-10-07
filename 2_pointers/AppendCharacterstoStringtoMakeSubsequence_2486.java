public class AppendCharacterstoStringtoMakeSubsequence_2486{
    class Solution {
    public int appendCharacters(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;
        while(i< n && j < m ){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return m-j;
    }
}



}