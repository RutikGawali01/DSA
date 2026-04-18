
import java.util.*;

public class Word_Ladder_2 {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        // for o(1) lookup - stored in set
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }

        Queue<List<String>> q = new LinkedList<>();

        List<String> tempPath = new ArrayList<>();
        tempPath.add(beginWord);
        q.add(tempPath);

        // Track words used at the current level to remove them later
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);

        int level = 0;
        List<List<String>> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            List<String> list = q.peek();
            q.remove();

            // erase all the  words that has been 
            //used in  previou s level to transform 
            if (list.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    set.remove(it);
                }
                usedOnLevel.clear();
            }

            String word = list.get(list.size() - 1);
            if (word.equals(endWord)) {
                // 1st seq  where we reached endword
                if (ans.size() == 0) {
                    ans.add(list);
                } // this  is for confirmation that shortest / or equal size  seq is added
                else if (ans.get(0).size() == list.size()) {
                    ans.add(list);
                }

            }

            char[] wordArray = word.toCharArray();

            for (int i = 0; i < word.length(); i++) {
                char originalChar = wordArray[i];
                //System.out.println("ab");
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    wordArray[i] = ch;
                    String transformed = new String(wordArray);
                    /// System.out.println("abc");
                    if (set.contains(transformed)) {
                        list.add(transformed);

                        //  java works by reference - 
                        List<String> temp = new ArrayList<>(list);

                        // q.add(list);
                        q.add(temp);
                        //mark as visited on that level
                        usedOnLevel.add(transformed);
                        // new word must be removed - for next sequence it will still in the seq if not removed here
                        list.remove(list.size() - 1); // 
                    }
                    wordArray[i] = originalChar;

                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        String beginWord = "bat", endWord = "coz";
        String[] List = {"hot", "dot", "dog", "lot", "log", "cog"};

        List<String> wordList = new ArrayList<>();
        wordList.add("pat");
        wordList.add("bot");;
        wordList.add("pot");
        wordList.add("poz");
        wordList.add("coz");
        //wordList.add("cog");

        System.out.println(findLadders(beginWord, endWord, wordList));

    }
}
