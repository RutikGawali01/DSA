import  java.util.*;
public  class PalindromePartitions{
    public static void Palindrome_Partitions(String s, int ind , List<String> path , List<List<String>> res){
        if(ind == s.length()){
           
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = ind ; i< s.length() ; i++){
            if(isPalindrome(s,ind , i)){
                path.add(s.substring(ind, i+1));
                Palindrome_Partitions(s, i+1, path, res);
                path.remove(path.size()-1);
            }
        }
    }

    public static boolean isPalindrome(String s , int start , int last){
        while(start < last){
            if(s.charAt(start++) != s.charAt(last--)) return  false;
        }
        return  true;
    }
    public static void main(String[] args) {

        String s = "aabb";
        List<String> path = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        Palindrome_Partitions(s, 0, path, res);

        System.out.println(res);                                            
        
    }
}