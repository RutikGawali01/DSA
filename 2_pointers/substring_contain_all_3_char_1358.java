import java.util.HashMap;

public class substring_contain_all_3_char_1358{

    public static int contain_3_char(String s ){
        int n = s.length();
        int count = 0;
        

        for(int i = 0 ; i< n ; i++){
            HashMap<Character , Integer> mpp = new HashMap<>();
            for(int j = i; j<n ; j++){
            
                char ch = s.charAt(j);
                mpp.put(ch , mpp.getOrDefault(ch, 0)+1);
                if(mpp.size()>= 3){
                    count++;
                }
            }
        }
        return count;
    }

    public static int contain_3(String s){
        int last_seen[] = {-1 , -1 ,-1};
        int n = s.length();
        int count = 0;
        for(int i  =0 ; i< n ; i++){
            last_seen[s.charAt(i)-'a'] = i;
            if(last_seen[0] != -1 && last_seen[1] != -1 && last_seen[2] != -1){
                count  = count + ( 1 + (Math.min( Math.min(last_seen[0] , last_seen[1]) , last_seen[2] )));
            } 
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(contain_3_char(s));
        System.out.println(contain_3(s));
    }
}