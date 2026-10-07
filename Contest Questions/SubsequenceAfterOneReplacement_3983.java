
public class SubsequenceAfterOneReplacement_3983 {

    /* You are given two strings s and t consisting of lowercase English letters.

You may choose at most one index in s and replace the character at that index with any lowercase English letter.

Return true if it is possible to make s a subsequence of t; otherwise, return false.
Example 1:

Input: s = "cat", t = "chat"

Output: true

Explanation:

Replace s[1] from 'a' to 'h'. The resulting string is "cht".
"cht" is a subsequence of "chat" because we can match 'c', 'h', and 't' in order.
Example 2:

Input: s = "plane", t = "apple"

Output: false

Explanation:

The characters 'p', 'l', and 'e' can be matched in t, but the remaining characters cannot be matched while preserving the required order.
     */

    public static boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] left = new int[n]; // prefix match - 
        int[] right = new int[n]; // suffix match- 

        if (n > m) {
            return false;
        }

        //  update left - prefix match 
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < m && s.charAt(i) != t.charAt(j)) {
                j++;
            }

            if (j == m) {
                left[i] = -1;
            } else {
                left[i] = j;
                j++;
            }
        }

        //  update right - suffix match 
        j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (j >= 0 && s.charAt(i) != t.charAt(j)) {
                j--;
            }

            if (j < 0) {
                right[i] = -1;
            } else {
                right[i] = j;
                j--;
            }
        }

        // already  subseq 
        if (left[n - 1] != -1) {
            return true;
        }

        // replacing if valid
        for (int i = 0; i < n; i++) {
            int leftpos = (i == 0) ? -1 : left[i - 1];

            int rightpos = (i == n - 1) ? m : right[i + 1];

            // i==  0 , i == n-1 , leftpos < rightpos -- these conditions  are must
            // i== 0 --for first char - no prefix exists
            // i == n-1 -- for last ele -- no suffix exists
            // leftpos < rightpos -- if both are equal -  then both prefix and suffix wants to use the same char - for replacement this is not valid
            if ((i == 0 || leftpos != -1) && (i == n - 1 || rightpos != -1) && (leftpos < rightpos)) {
                return true;
            }

        }

        return false;

    }
}
