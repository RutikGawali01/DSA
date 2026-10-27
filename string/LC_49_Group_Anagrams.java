import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_49_Group_Anagrams {

    class Solution {
        // this takes O(n ) time - as char are fixed - 26 lowercase
        public static String sortString(String s) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)-'a']++;
            }

            StringBuilder sb = new StringBuilder(s.length());
            for (int ch = 0; ch < 26; ch++) {
                while (count[ch] > 0) {
                    sb.append((char)( ch + 'a'));
                    count[ch]--;
                }
            }
            return sb.toString();
        }

        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();


            for (String str : strs) {
                // String sorted = Arrays.sort(str.toCharArray()).toString();
                // char[] sortchar = Arrays.sort(str.toCharArray());
                String sorted = sortString(str);
                List<String> values = new ArrayList<>();
                if (map.containsKey(sorted)) {
                    values = map.get(sorted);
                    values.add(str);
                } else {
                    values.add(str);

                }
                map.put(sorted, values);
            }
            List<List<String>> res = new ArrayList<>();
            for (Map.Entry<String, List<String>> entries : map.entrySet()) {
                List<String> val = entries.getValue();
                res.add(val);
            }
            return res;
        }
    }
}
