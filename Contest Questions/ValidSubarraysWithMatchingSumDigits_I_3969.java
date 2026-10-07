
public class ValidSubarraysWithMatchingSumDigits_I_3969 {

    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                long temp = sum;
                long firstdig = -1;
                long lastdig = sum % 10;
                 if(lastdig != x) continue;
                while (temp != 0) {
                     firstdig = temp % 10;
                    temp = temp / 10;
                }

                if ((firstdig == x) && (lastdig == x)) {
                    cnt++;
                 }

            }
        }

        return cnt;

    }

    public static void main(String[] args) {
        int[] nums = {445101066, 889962558};



        int x = 6;

        // System.out.println(countValidSubarrays(nums, x));

        int n = 86788;
        System.out.println(n /   n-1);
        // String s = Integer.toString(n);
        // System.out.println(s);
    }
}
