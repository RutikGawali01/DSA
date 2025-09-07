
import java.util.*;

public class Nearby_Cars{
    //leetcode 973
    
    //  we created class Point because we needed extra information to store in the priority queue:(x,y,distSq, inndex)
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int ind;

        public Point(int x, int y , int distSq , int ind){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.ind = ind;
        }

        // this method is part of Comparable interface
        // use to how to compare two object
        @Override 
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
        //smallest distance at top of priority queue
    }
    public static void main(String[] args) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i = 0; i<pts.length ; i++){
            int distSq = pts[i][0]*pts[i][0] +  pts[i][1]* pts[i][1];

            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }   
        

        for(int i = 0; i<k ; i++){
            System.out.println("C"+pq.remove().ind);
        }

        // this is used to return an 2-d array

         /*int[][] result = new int[k][2]; // k rows and 2 column for x,y

        for (int i = 0; i < k; i++) {
            Point p = pq.poll(); // closest point
            result[i][0] = p.x;
            result[i][1] = p.y;
        }

        return result;*/
    }
}