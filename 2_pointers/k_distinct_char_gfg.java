
import java.util.HashMap;

public class k_distinct_char_gfg {

    public static int k_distinct(String s , int k ){
        int n = s.length();
        int max_len =0;

        
        HashMap<Character, Integer> mpp = new HashMap<>();
        for(int i = 0 ; i< n ; i++){
            mpp.clear();
            for(int j =i; j< n ; j++){
                char ch  = s.charAt(j);
                mpp.put(ch , mpp.getOrDefault(ch, 0)+1);
                if(mpp.size() <= k){
                    max_len = Math.max(max_len , j-i+1);
                }else{
                    break;
                }
            }
        }
        return max_len;

    }


    public static int k_distinct_char(String s , int k){
        int max_len = -1;
        int l = 0;
        int r = 0;
        int n = s.length();

        HashMap<Character , Integer> mpp = new HashMap<>();
        while(r<n){
            char  ch = s.charAt(r);
            mpp.put(ch , mpp.getOrDefault(ch , 0)+1);
            if(mpp.size()>k){
                char c =s.charAt(l);
                mpp.put(c, mpp.getOrDefault(c , 0)-1);
                if(mpp.getOrDefault(c , 0) == 0){
                    mpp.remove(s.charAt(l));
                }
                l++;
            }
            if(mpp.size() == k){
                max_len = Math.max(max_len , r-l+1);
            }
            r++;

        }
        return max_len;

    }
    public static void main(String[] args) {
        // String s = "aabacbebebe";
        String s= "tvtgv";
        int k = 4;
        System.out.println(k_distinct(s, k));
        System.out.println(k_distinct_char(s, k));
        
    }
}
