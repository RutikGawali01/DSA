import java.util.Arrays;
public class Job_sequencing_gfg{

    static class Job{
        int id;
        int deadline;
        int profit;

        public Job(int id , int deadline , int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    // this is used bcz solution is causing TLE 
    // Disjoint Set (Union-Find) for slot management
    private static int find(int parent[], int s) { // s is deadline
        if (parent[s] == s) return s;
        return parent[s] = find(parent, parent[s]); // path compression
    }

    public static int[] jobSequencingProblem(Job[] arr ){
        Arrays.sort(arr , (a,b) -> (b.profit - a.profit)); // sort on the basis of profit  in descending order

        int maxi = -1;
        int n = arr.length;
        for(int i = 0; i < n ; i++){
            maxi = Math.max(maxi, arr[i].deadline);
        }
        /*int result[] = new int[maxi+1];
        for(int i = 0 ; i < result.length ; i++){
            result[i] = -1;
        }*/   

        // initialize DSU parent array
        int parent[] = new int[maxi + 1];
        for (int i = 0; i <= maxi; i++) parent[i] = i;


        int maxProfit = 0;
        int maxJobs =0;
        // traversing through jobs
        // this  inner loop is causing Time Limit exceeds 
        for(int i = 0 ; i< n ; i++){
            /*for(int j = arr[i].deadline ; j> 0 ; j--){
                if(result[j] == -1){
                    maxJobs++;
                    result[j] = arr[i].id; // in result array store that job id 
                    maxProfit += arr[i].profit;
                    break;
                }
            }*/
            int availableSlot = find(parent, arr[i].deadline);
            if (availableSlot > 0) {   // valid slot found
                parent[availableSlot] = find(parent, availableSlot - 1); //  for storing next ele nearby to the available slot
                maxJobs++;
                maxProfit += arr[i].profit;
            }
        }
        return new int[]{maxJobs , maxProfit};
    }


    public static void main(String[] args) {

        int deadline[] = {4, 1, 1, 1};
        int profit[] = {20, 10, 40, 30};

    

        Job a[] = new Job[profit.length];

        for(int i = 0 ; i< profit.length; i++){
            a[i] = new Job(i+1 , deadline[i] , profit[i]);
        }


        int[] res = jobSequencingProblem(a);

        for(int i = 0 ; i< res.length ; i++){
            System.out.println(res[i]);
        }

        
    }
}