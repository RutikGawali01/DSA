
public class MoveZeroToEnd {
    // move all zero's to end of an array  -----> 

    // opproach 1->> 2 pointers for compare and finding zero position  
    public static int[] moveZero(int[] arr) {
        // step 1 --> find out 1st 0's poosition in an array if not a single 0 found return given array
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return arr;
        }

        // step 2 --> start traversing from j+1 to n  and swap if non-zero found
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                arr[i] = 0;

                j++;
            }
        }
        return arr;

    }

    // opproach 2 
    public static int[] moveZeros(int[] arr) {
        int nonzero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonzero] = arr[i];
                if (nonzero != i) {
                    arr[i] = 0;
                }
                nonzero++;
            }

        }
        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 0, 4, 5, 0, 0, 3};

        int[] ans = moveZeros(arr);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
}
