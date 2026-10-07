
import java.util.*;

public class Happy_Number_202 {

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1) {
            int num = n;
            int sum = 0;

            if(seen.contains(n)){
                return false;
            }else{
                seen.add(n);
            } 

            while (num != 0) {
                int dig = num % 10;
                sum += dig * dig;
                num = num / 10;
            }

            n = sum;
        }

        return true;
    }
}
