public class minimum_window_substring_76 {


    // this is not a proper solution this is valid oly for some test cases   --> tc = O(n^2);
    public static String min_window_subString(String s , String t){
        int n = s.length();
        int m = t.length();
        int min_len = Integer.MAX_VALUE;
        int start_index = 0;        
        for(int i = 0 ; i< n ; i++){
            int count = 0;
            int freq_of_t[] = new int[256];
            for(int j = 0 ; j < m ; j++){
                freq_of_t[t.charAt(j)]++;
            }
            for(int j = i ; j<n ;j++){
                if(freq_of_t[s.charAt(j)] > 0){
                    count++;
                }    
                    freq_of_t[s.charAt(j)]--;
                if(count == m ){
                    if( (j-i+1 )< min_len){
                        min_len = j-i+1;
                        start_index = i;
                        break;
                    }
                }
                
                
            }
        }
        String result = s.substring(start_index, start_index+min_len);
        return result;
    }
    
    //Optimal  ----> Tc = O(2n)+ O(m) and  SC = O(256);
    // dry run for better understanding 
    public static String Min_window_SubString(String s , String t ){
        int n = s.length();
        int m = t.length();
        int count = 0;
        int min_len = Integer.MAX_VALUE;
        int start_index = -1;

        int freq_of_t[] = new int[256];
        for(int i  = 0; i< m ; i++){
            freq_of_t[t.charAt(i)]++;
        }
        int left = 0 ;
        int right = 0;
        while(right < n ){
            if(freq_of_t[s.charAt(right)] > 0){
                count++;
            }
            freq_of_t[s.charAt(right)]--;
            while(count == m){
                if((right -left +1) < min_len){
                    min_len = (right - left +1);
                    start_index = left;
                }
                freq_of_t[s.charAt(left)]++; // when we remove left char then change occurances 
                if(freq_of_t[s.charAt(left)] > 0){ // if removing left char still > 0 then decrease count bcz we remove left char 
                    count--;
                }
                left++;
            }
            right++;
        }
        return start_index == -1 ? "": s.substring(start_index, start_index + min_len);
    }
    public static void main(String[] args) {
        String s= "DDAAABBCA";
        String t = "ABC";
        // String ans = min_window_subString(s, t);
        // System.out.println(ans);
        System.out.println(Min_window_SubString(s, t));

    }
}
