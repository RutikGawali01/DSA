import java.util.*;

public class Number_of_Strings_That_Appear_as_Substrings_inWord_1967{
    
    class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        int n =  patterns.length;
        for(int i = 0 ; i < n ; i++ ){
            if(word.contains(patterns[i])){
                count++;
            }
        }
        return count;
    }
}

    public static void main(String[] args){
        String word = "abc";
        // word.contains("a");
        
        //  System.out.println( word.contains("d") );


    }
}