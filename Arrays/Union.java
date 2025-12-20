
import java.util.ArrayList;

public class Union {
    //union of 2 sorted array

    // brute force solution -->  Using set bcz set stores all unnique elements
    // optimal --> using 2 pointers approach
    // TC -> O(n1+n2)
    public static ArrayList<Integer> unionOfTwoArray(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n1 = a.size();
        int n2 = b.size();
        int i = 0;
        int j = 0;
        ArrayList<Integer> union = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (a.get(i) <= b.get(j)) {
                if (union.size() == 0 || union.get(union.size() - 1) != a.get(i)) {
                    union.add(a.get(i));
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != b.get(j)) {
                    union.add(b.get(j));
                }
                j++;
            }
        }
        while (i < n1) {
            if (union.size() == 0 || union.get(union.size() - 1) != a.get(i)) {
                union.add(a.get(i));
            }
            i++;
        }

        while (j < n2) {
            if (union.size() == 0 || union.get(union.size() - 1) != b.get(j)) {
                union.add(b.get(j));
            }
            j++;
        }
        return union;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);

        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(4);
        b.add(5);
        b.add(6);

        System.out.println(unionOfTwoArray(a, b));
    }
}
