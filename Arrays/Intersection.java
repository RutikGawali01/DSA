
import java.util.ArrayList;

public class Intersection {
    // intersection pf 2 sorted array

    // using 2 pointer - if equal in both array then add
    public static ArrayList<Integer> intersectionOfTwoArrayList(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n1 = a.size();
        int n2 = b.size();
        int i = 0;
        int j = 0;
        ArrayList<Integer> intersection = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (a.get(i) < b.get(j)) {
                i++;
            } else if (a.get(i) > b.get(j)) {
                j++;
            } else {
                intersection.add(a.get(i));
                i++;
                j++;
            }
        }
        return intersection;

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

        System.out.println(intersectionOfTwoArrayList(a, b));
    }
}
