
import java.util.HashSet;

public class RemoveDuplicates {
    //remove duplicates from sorted array and return Number of unique elements

    // opproach 1 - > using set data structure
    public static int RemoveDuplicatesFromSortedArray(int[] arr) {
        HashSet<Integer> st = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            st.add(arr[i]);
        }

        int index = 0;
        for (Integer it : st) {
            arr[index] = it;
            index++;
        }
        return index;
    }

    // simple opproach -- using 2 pointers 
    // TC - > O(n) 
    public static int RemoveDuplicatesFromArray(int[] arr) {
        int i = 0;
        for (int j =  1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;
            }
        }
        return (i + 1);
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 3, 3};

        //System.out.println(RemoveDuplicatesFromSortedArray(arr));  
        //int [] ans = RemoveDuplicatesFromSortedArray(arr);
        // for(int i = 0 ; i< ans.length ; i++){
        //     System.out.println(ans[i]);
        // }

        System.out.println(RemoveDuplicatesFromArray(arr));

    }

}
