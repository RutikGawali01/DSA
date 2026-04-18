public class  Floyd_Warshall_Algo{

    public void floydWarshall(int[][] dist) {
        int n = dist.length;
         
        // traversing through all the vertex for shortest path 
        for(int  k = 0 ; k<n ; k++){
            for(int i = 0 ; i< n ; i++){
                for(int j = 0; j< n ;j++){
                    if(i == j ){
                        dist[i][j] = 0;
                        continue;
                    } 
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        
    }
}