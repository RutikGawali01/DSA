import java.util.HashSet;

public class LC_4090_Count_Magical_Substring_Pairs_I {
    class Solution {
        public int countMagicalPairs(String s) {

            // brute force with 3 loops
            //  both sub-strings are separeated by  fixed point - j
            // instead of 3 pointers - fix single j pointers -

            // generate all sub-strings ending at j
            // generate all sub-strings starting at j+1



            //  instead of hash-sets we can  use boolean vis - seen array - as only lowercase english letters are there   along with distinct var -
            // when we make vis as true - update - distinct ++

            // curre TC - n^2


            int n = s.length();

            int res = 0;
            for (int j = 0; j < n - 1; j++) {
                // lefft substrins ending at j
                int[] left = new int[27];
                Set<Character> s1 = new HashSet<>();
                int i = j;
                while (i >= 0) {
                    s1.add(s.charAt(i));
                    left[s1.size()]++;
                    i--;
                }

                // right substrings = starting at j+1;
                int k = j + 1;
                // int[] right = new int[27];
                Set<Character> s2 = new HashSet<>();
                while (k < n) {
                    s2.add(s.charAt(k));
                    res += left[s2.size()];
                    // right[s2.size()]++;
                    k++;
                }

                // for (int l = 1; l < 27; l++) {
                //     if (left[l] > 0 && right[l] > 0) {
                //         res += left[l] * right[l];
                //     }
                // }

            }
            return res;
        }
    }
}
