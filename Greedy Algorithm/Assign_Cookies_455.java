import java.util.*;
public class Assign_Cookies_455{

    public static  int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int n = g.length;
        int  m = s.length;
        int l =0; // s
        int r= 0; // g
        while(l < m && r < n ){
            if(s[l] >= g[r]){
                r++;
            }
            l++;
        }
        return r;
    }
    public static void main(String[] args) {
         int[] g = {1,2,3};
         int[] s = {1,1};
         System.out.println(findContentChildren(g, s));
    }
}