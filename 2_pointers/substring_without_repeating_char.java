

public class substring_without_repeating_char {

    // brute force with tc -= O(N^2)
   /* public static int without_repeating_char(String str){
        int max_len = 0;
        // int len = 0;
        int n = str.length();
        for(int i = 0 ; i < n ; i++){
            int hash[] = new int[256];
            for(int j = i ; j<n ; j++){
                if(hash[str.charAt(j)] == 1){
                    break;
                }
                int len = j-i+1;
                max_len = Math.max(len , max_len);
                hash[str.charAt(j)] = 1;

            }
        }
        return max_len;

    }*/

    public static int without_repeating_char(String str ){
        int n = str.length();
        int left = 0;
        int right = 0;
        int hash[] = new int[256];
        int max_len = 0;
        int len = 0;
        while(right < n){
            if(hash[str.charAt(right)] == 0){
                len = right- left+1;
                max_len = Math.max(max_len , len);
                hash[str.charAt(right)]++;
                right++;
            }else if(hash[str.charAt(right)] >= 1){
                hash[str.charAt(left)]  = 0;
                left++;
            }
        }
        return max_len;
         
    }
   
    public static int without_repeating(String str ){
        int l = 0;
        int r = 0;
        int max_len = 0;
        int len = 0;
        int hash[] =  new int[256];
        for(int i = 0; i< 256 ; i++){
            hash[i] = -1;
        }
        int n = str.length();

        while(r < n){
            if(hash[str.charAt(r)] != -1){// check ifis in the map or not 
                if(hash[str.charAt(r)] >= l){//if yes check for is it occur before l or not 
                    l = hash[str.charAt(r)]+1;
                }
            }
            len =  r-l+1;
            max_len = Math.max(len , max_len);
            hash[str.charAt(r)] = r;
            r++;
        }
        return max_len;

    }
    public static void main(String[] args) {
        String str = "bbbbb";
        System.out.println(without_repeating_char(str));
        System.out.println(without_repeating(str));

    }
}
