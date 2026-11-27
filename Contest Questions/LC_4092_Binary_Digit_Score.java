public class LC_4092_Binary_Digit_Score {
    class Solution {
        public int calculateScore(int a, int b) {

            //  to check is ith bit is set or not - if non zero - set
            // N & (1 << i)
            int s1 = 0;
            int s2 = 0;

            for (int i = 0; i <= 8; i++) {

                if ((a & (1 << i)) != 0) {
                    s1++;
                }

                if ((b & (1 << i)) != 0) {
                    s2++;
                }

            }

            if (s1 >= s2)
                return s1 * s2;

            return s2 / s1;
        }
    }
}
