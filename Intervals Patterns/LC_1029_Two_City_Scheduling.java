import  java.util.*;
public class LC_1029_Two_City_Scheduling {
    public static int twoCitySchedCost(int[][] costs) {
        // every persons must go to exactly one city
        // both cities a and b - equal no of people
        int n = costs.length /2;

        // how much money do I save by sending them to City A instead of City B
        // by diff of both the costs of each people-
        // Difference = City A cost - City B cost

        // int[] = {diff of costs of people  , people }
        //  min heap queue
        /*
            A negative difference means City A is cheaper.
            A positive difference means City B is cheaper.
            A smaller difference means City A is more favorable relative to City B.
        */
        PriorityQueue<int[]> diff = new PriorityQueue<>((a,b) -> Integer.compare(a[0] , b[0]));


        int people = 0;
        for(int[] cost : costs){
            diff.add(new int[]{cost[0]-cost[1] , people});
            people++;
        }
//  diff =  means - tevadhi cost mi save keli A choose karun instead of B city -
//

        // starting che n min diff - choose city A  -
        // jevha mmi min diff wali cost select karto - tyaveles -
        // city a choose kelyananter - mi min cost save karto instead of  city B select karun
        // first top n min diff - A city  -
        // rem n - city B
        int res = 0;
        while(!diff.isEmpty()){
            int[] tmp = diff.poll();
            people = tmp[1];
            if(n > 0 ){
                res += costs[people][0];
                n--;
            }else{
                res += costs[people][1];
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] costs  =  {{259,770}, {448,54},{926,667},{184,139},{840,118}};

        System.out.println(twoCitySchedCost(costs));

    }
}