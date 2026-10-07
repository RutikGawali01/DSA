
public class Valid_palindrome_125 {

    class Solution {

        public boolean isPalindrome(String s) {
            int n = s.length();
            int i = 0;
            int j = n - 1;
            s = s.toLowerCase();

            while (i < j) {
                char ith = s.charAt(i);
                char jth = s.charAt(j);
                if (ith == jth) {
                    i++;
                    j--;
                } else if (!('a' <= ith && ith <= 'z') && !(ith >= '0' && ith <= '9')) {
                    i++;
                } else if (!('a' <= jth && jth <= 'z') && !(jth >= '0' && jth <= '9')) {
                    j--;
                } else if (ith != jth) {
                    return false;
                }
            }
            return true;

        }
    }

    
    public static void main(String[] args) {

    }
}
