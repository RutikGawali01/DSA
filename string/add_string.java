

public class add_string {

    public static String add(String num1 , String num2){
        int ind1 = num1.length()-1;
        int ind2 = num2.length()-1;
        int sum = 0;
        int carry = 0;
        String ans = "";
        while(ind2>=0){
            sum = (num2.charAt(ind2)-'0') +( num1.charAt(ind1)-'0') + carry;
            carry = sum/10;
            char c = (char)(sum%10 +'0');
            ans+=c;
            ind1--;
            ind2--;
        }

        while(ind1>=0){
            sum = (num1.charAt(ind1)-'0')+ carry;
            carry = sum/10;
            char c = (char)(sum%10 + '0');
            ans +=c;
            ind1--;
        }
        return ans;

    }
    public static String  reverse(String str){
        String res = "";
        int ind = str.length()-1;
        while( ind >= 0){
            res+=str.charAt(ind);
            ind--;
        }
        return res;
    }
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        if(num1.length()>num2.length()) {
            String f_ans =  add(num1 , num2);
            System.out.println(reverse(f_ans));
        }
        else{
            String f_ans = add(num2 , num1);
            System.out.println(reverse(f_ans));
        }
        
    
    }
}
