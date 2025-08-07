
public class sort_sentence {
    public static String sorting_sentence(String str){
        StringBuilder s = new StringBuilder(str);
        StringBuilder temp = new StringBuilder();
        
        StringBuilder freq[] = new StringBuilder[10];
        int count = 0;
        for(int i =0; i<str.length();i++){
            if(str.charAt(i)==' '){
                int pos = temp.charAt(temp.length()-1)-'0';
                
                // int pos = (int)((temp.length()-1)-'0');
                temp.deleteCharAt(temp.length()-1);
                freq[pos] = temp;
                temp = new StringBuilder();
                count++;

            }else{
                temp.append(s.charAt(i));
            }
        }
            int pos = temp.charAt(temp.length()-1)-'0';
            temp.deleteCharAt(temp.length()-1);
            freq[pos] = temp;
            temp = new StringBuilder();
            count++;

            for( int i = 1; i<= count ; i++){
                temp.append(freq[i]);
                temp.append(' ');

            }
            return temp.toString();
    }
    public static void main(String[] args) {
        String str  = "is2 sentence4 this1 a3";
        System.out.println(sorting_sentence(str));

    }    
}
