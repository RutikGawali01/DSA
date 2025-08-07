public class String_matching_28 {
        //brute force of tc = O(n *M);
        public static int string_matching(String str1 , String str2){
            int n = str1.length();
            int m = str2.length();
                for(int i =0 ; i<= n-m ; i++){
                    int first = i;
                    int sec = 0;
                        while(sec< m){
                            if(str1.charAt(first) != str2.charAt(sec)){
                                break;
                            }else{
                                first++;
                                sec++;
                            }
                }
                if(sec == m){
                    return first-sec;
                }
                }
                return -1;
        }


    // optimal 
    public static void find_lps(int[] lps , String s2){

        int n = s2.length();
        int pre = 0;
        int suf = 1;
        while(suf < n){
            if(s2.charAt(pre) == s2.charAt(suf)){
                lps[suf] = pre +1;
                pre++;
                suf++;
            }else{
                if(pre == 0){
                    lps[suf] = 0;
                    suf++;
                }else{
                    pre = lps[pre-1];
                }
            }

        }
    }
    public static int String_matching_optimal(String s1 , String s2){
        int lps[] = new int[s2.length()];
        find_lps(lps , s2);
        int first = 0;
        int sec = 0;
        while(first < s1.length() && sec < s2.length()){
            if(s1.charAt(first) == s2.charAt(sec)){
                first++;
                sec++;
            }else{
                if(sec == 0){
                    first++;
                }else{
                    sec = lps[sec-1];
                }
            }

        }
            if(sec == s2.length()){
                return first-sec;
            }
        return -1;
    }
        
    public static void main(String[] args) {
            String str1 = "abcdaabceaabceaabdop";
            String str2 = "aabceaabdo";
            System.out.println(String_matching_optimal(str1, str2));
    }
    
}
