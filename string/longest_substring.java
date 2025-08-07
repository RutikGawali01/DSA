

public class longest_substring {
    public static int longestSubstring(String str ){
        int[] freq = new int [256];
        int len = 0;
        int first = 0;
        int second = 0;
        while(second < str.length()){
            while(freq[str.charAt(second)] > 0){
                freq[(int)(str.charAt(first))]=0;
                first++;
            }
            freq[(int)(str.charAt(second))] = 1;
            len = len > (second -first +1) ? len : (second -first+1);
            second++;
        }
        return len;
    }
    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(longestSubstring(str));
    }
    
}
