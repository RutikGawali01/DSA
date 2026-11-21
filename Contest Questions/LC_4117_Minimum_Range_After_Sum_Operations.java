public class LC_4117_Minimum_Range_After_Sum_Operations {
        public int minRange(int a, int b, int c) {

            if(a == b && b == c) return 0;
            int sum = a+b+c;



            int max = Math.max(a , Math.max(b,c));
            int min = Math.min(a , Math.min(b,c));

            int res  = max-min;

            a = min;
            b = sum- ( min+max) ;

            c = max;

            if(a+b < c){
                c = a+b;
            }

            max = Math.max(a , Math.max(b,c));
            min = Math.min(a , Math.min(b,c));

            res = Math.min(res , max-min);
            return res;









        }
    }
