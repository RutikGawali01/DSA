
import java.util.*;

public class Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_ThresholdDistance {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        // Arrays.fill(dist, 1e8);
        for(int i = 0 ; i< n ; i++){
            for(int j = 0;j<n ;j++){
                dist[i][j] =1e8
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        // floyd Warshall Algorithm - multisource shortest path- 
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        dist[i][j] = 0;
                        continue;
                    }
                    if (dist[i][k] != 1e8 && dist[k][j] != 1e8) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int countMax = n + 1;
        int city = -1;// city to be return - 
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if(count <= countMax){
                 countMax = count;
                 city = i;
            }

        }

        return city;

    }

    public static void main(String[] args) {

    }
}
