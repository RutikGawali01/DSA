import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Pair{
    char ch ;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

}


public class LC_1405_Longest_Happy_String {
    public static String longestDiverseString(int a, int b, int c) {
//        0-a ,, 1-b ,, 2 -c

        PriorityQueue<Pair> pq = new PriorityQueue<>( (x , y)-> Integer.compare(y.freq , x.freq));
        if(a != 0 ) pq.add(new Pair('a' , a));
        if(b != 0 ) pq.add(new Pair('b' , b));
        if(c != 0 ) pq.add(new Pair('c' , c));


        StringBuilder sb = new StringBuilder();

        while(pq.size() >= 2){
            Pair first = pq.poll();
            int first_freq = first.freq;
            Pair sec = pq.poll();
            int sec_freq = sec.freq;

            if(sb.length() < 2 ){
                if(first.freq >=1 ){
                    sb.append(first.ch);
                    first_freq = first_freq-1;
                }
            }else if(sb.length() >= 2 &&  (sb.charAt(sb.length()-1 ) != first.ch || sb.charAt(sb.length()-2) != first.ch )){
                if(first.freq >= 1){
                    sb.append(first.ch);
                    first_freq -=1;
                }
            } else if (sb.length() >= 2 && (sb.charAt(sb.length()-1) != sec.ch || sb.charAt(sb.length()-2) != sec.ch) ) {
                if(sec.freq >= 1) {
                    sb.append(sec.ch);
                    sec_freq -= 1;
                }
            }
            if(first_freq != 0){
                pq.add(new Pair(first.ch,  first_freq));
            }
            if(sec_freq != 0) pq.add(new Pair(sec.ch,  sec_freq));
        }


        while(pq.size() == 1){
            Pair  last = pq.poll();
            int last_freq = last.freq;

            if (sb.length() >= 2 && (sb.charAt(sb.length()-1) != last.ch || sb.charAt(sb.length()-2) != last.ch)){
                if(last.freq >=1 ){
                    sb.append(last.ch);
                    last_freq -= 1;
                    if(last_freq != 0 ) pq.add(new Pair(last.ch,  last_freq));
                }
            }else if( sb.length() < 2){
                if(last.freq >=1 ){
                    sb.append(last.ch);
                    last_freq -= 1;
                    if(last_freq != 0 ) pq.add(new Pair(last.ch,  last_freq));
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(longestDiverseString(1 , 1, 7));
    }
}
