public class longest_repeating_char_replacement_424 {

    //brute force  --> this will givw TLE in leetcode bcz of O(n^2) 
    public static int replace_char(String s , int k){
        int max_len = 0;
        int n = s.length();
        for(int i = 0 ; i< n ; i++){
            int hash[] = new int[26];
            int max_freq = 0 ;
            for(int j  = i ; j < n ; j++){
                hash[s.charAt(j)-'A']++;
                max_freq = Math.max(max_freq , hash[s.charAt(j)-'A']);
                int changes = (j-i+1)-max_freq;
                if(changes <= k ){
                    max_len = Math.max(max_len , j-i+1);
                }else{
                    break;
                }

            }

        }
        return max_len;
    }

    // optimal

    public static int replace_char_repeat(String s , int k){
        int n = s.length();
        int left = 0;
        int right = 0;
        int max_freq = 0;
        int max_len = 0;
        int hash[] = new int[26];
        while(right < n){
            hash[s.charAt(right)-'A']++;
            max_freq = Math.max(max_freq , hash[s.charAt(right)-'A']);
            /*while((right - left +1) - max_freq > k){
                hash[s.charAt(left)-'A']--;
                max_freq =  0;
                for(int i = 0; i< 26 ; i++){
                    max_freq = Math.max(max_freq , hash[i]);
                }
                left++;
            }*/

            if((right - left +1) - max_freq > k){
                hash[s.charAt(left)-'A']--;
                left++;
            }

            if((right - left +1) - max_freq <= k){
                max_len = Math.max(max_len, right - left +1);

            }
            right++;
        }
        return max_len;

    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;
        System.out.println(replace_char(s, k));
        System.out.println(replace_char_repeat(s, k));
        
    }
}
