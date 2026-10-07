
public class Valid_palindrome_II_680 {

    /*Given a string s, return true if the s can be palindrome after deleting at most one character from it.

        Example 1:

        Input: s = "aba"
        Output: true
        Example 2:

        Input: s = "abca"
        Output: true
        Explanation: You could delete the character 'c'.
        Example 3:

        Input: s = "abc"
        Output: false */
    public boolean helper(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return helper(i + 1, j, s) || helper(i, j - 1, s);
                // helper(i+1  , j , s)  - ith ele removed
                // helper(i , j-1 , s); - jth ele removed
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
