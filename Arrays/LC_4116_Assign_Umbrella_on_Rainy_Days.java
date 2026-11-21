public class LC_4116_Assign_Umbrella_on_Rainy_Days {
    class Solution {
        public String[] assignUmbrella(int[] rain) {
            int n = rain.length;

            int a = 0;
            int b = 0;
            String[] res = new String[n];

            boolean alice = false;
            boolean bob = false;

            for (int i = 0; i < n; i++) {
                alice = false;
                bob = false;
                if (i < n - 1 && (rain[i] == 1 && rain[i + 1] == 1)) {
                    alice = true;
                    // res[i] = "Alice";

                }
                if (rain[i] == 1) {
                    bob = true;
                    // res[i] = "Bob";

                }

                if (alice == true && bob == true) {
                    if (a < b) {

                        res[i] = "Alice";
                        a++;
                    } else if (a > b) {
                        b++;
                        res[i] = "Bob";
                    } else if (a == b) {
                        a++;

                        res[i] = "Alice";
                    }
                } else if (alice) {
                    res[i] = "Alice";
                    a++;
                } else if (bob) {
                    res[i] = "Bob";
                    b++;
                } else {
                    res[i] = "None";
                }

            }

            return res;

        }
    }
}
