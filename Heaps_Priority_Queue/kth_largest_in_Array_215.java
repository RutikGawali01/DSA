import java.util.PriorityQueue;
import java.util.Comparator;
public class kth_largest_in_Array_215 {
    //leetcode 215

    

    public static int kth_largest(int[] arr , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0 ; i< arr.length ;i++){
            pq.add(arr[i]);
        }
        
        int kth=-1;
        for(int i = 0; i<k; i++){
            kth = pq.poll();// insttead of this .remove() can be added but when empty .remove() throws exception and poll  return null .
        }
        return kth;

    }

    public static void main(String[] args) {
        int [] arr = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(kth_largest(arr, k));
        }
}