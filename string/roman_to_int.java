public class roman_to_int {
    public static int num(char c){
        if(c == 'I'){
            return 1;
        }else if(c == 'V'){
            return 5;
        }else if(c == 'X'){
            return 10;
        }else if(c == 'L'){
            return 50;
        }else if(c == 'C'){
            return 100;
        }else if(c == 'D'){
            return 500;
        }else{
            return 1000;
        }
    }
    public static int romanToInt(String str){
        int ind = 0;
        int sum = 0;
        while(ind < str.length()-1){
            if(num(str.charAt(ind)) < num(str.charAt(ind+1))){
                sum -= num(str.charAt(ind));
            }else{
                sum += num(str.charAt(ind));
            }
            ind++;
        }
        sum += num(str.charAt(ind));
        return sum;
    }
    public static void main(String[] args) {
        String str = "XLIII";
        System.out.println(romanToInt(str));
    }
}
