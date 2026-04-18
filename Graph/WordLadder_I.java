
import java.util.*;

public class WordLadder_I {

    static class Pair {

        String word;
        int len;

        public Pair(String word, int len) {
            this.word = word;
            this.len = len;
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // we converted list into set for O(1) lookup --
        Set<String> st = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            st.add(wordList.get(i));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        st.remove(beginWord); // if at any case - beginword exists

        // Tc - N - list.size
        
        while (!q.isEmpty()) {
            String word = q.peek().word;
            int currlen = q.peek().len;
            q.poll();

            if (word.equals(endWord)) {
                return currlen;
            }

            // char[] is better instead of stringbuilder considering new object creation 
            // multiple copies of string in heap memory
            char[] wordArray = word.toCharArray();

            // TC - word.length * 26 
            for (int i = 0; i < word.length(); i++) {
                char originalChar = wordArray[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    // StringBuilder sb = new StringBuilder(word);
                    //sb.setCharAt(i, ch);

                    if (ch == originalChar) {
                        continue;
                    }
                    wordArray[i] = ch;
                    String transformed = new String(wordArray);

                    if (st.contains(transformed)) {
                        st.remove(transformed);
                        q.add(new Pair(transformed, currlen + 1));
                    }

                }
                wordArray[i] = originalChar; //Restore original character
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] List = {"hot","dot","dog","lot","log","cog"};
        

        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");;
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
