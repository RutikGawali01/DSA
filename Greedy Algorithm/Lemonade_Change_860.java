public class Lemonade_Change_860{

    public static  boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0;
        int ten = 0;
        for(int i = 0 ; i< n; i++){
            if(bills[i] == 5){
                five++;
            }else if(bills[i] == 10){
                if(five != 0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
                
            }else{
                if(five != 0 && ten != 0 ){
                    five--;
                    ten--;
                }else if(five >= 3){
                    five = five-3;
                }else{
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.print(lemonadeChange(bills));
    }
}