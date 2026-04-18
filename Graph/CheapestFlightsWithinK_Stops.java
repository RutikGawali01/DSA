import java.util.*;
public class CheapestFlightsWithinK_Stops{

   static  class Tuple{
        int stops;
        int node;
        int price;
        public Tuple(int stops , int node  , int price){
            this.stops = stops;
            this.node = node;
            this.price = price;
        }
    }

    static class Pair{
        int v;
        int wt;
         public Pair(int v, int wt){
            this.v =v;
            this.wt = wt;
         }
    }


    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0 ; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : flights){
            int U = edge[0];
            int V = edge[1];
            int w = edge[2];

            adj.get(U).add(new Pair(V, w));
        }

         Queue<Tuple> q = new LinkedList<>();

        // {stops , node  , price }
        q.add(new Tuple(0 , src , 0 ));


        int[] dist = new int[n];
        dist[src]= 0;
        Arrays.fill(dist, (int)(1e9));


        while(!q.isEmpty()){
            Tuple curr = q.poll();
            int stops = curr.stops;
            int node = curr.node;  
            int currPrice  = curr.price;
           


            if( stops > k ) continue;

            for(Pair pair : adj.get(node)){
                int adjnode = pair.v;
                int adjPrice= pair.wt;

                if(currPrice + adjPrice < dist[adjnode] && stops <= k){
                    dist[adjnode] = currPrice + adjPrice;
                    q.add(new Tuple(stops+1, adjnode, adjPrice+currPrice));
                }
            }
        }

            if(dist[dst] == 1e9) return -1;
            return dist[dst];
    
    }

    public static void main(String[] args) {
         int n = 3;
         int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
         int src = 0;
         int dst = 2;
         
         int k = 1;

         System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}