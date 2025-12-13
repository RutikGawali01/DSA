
import java.util.ArrayList;

public class representation {

    public static void main(String[] args) {

        // using ArayaList --> O(2N)
        int n = 3;
        int m = 3;
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        // n+1 lists in matrix 
        for (int i = 0; i <= n; i++) {
            mat.add(new ArrayList<>());
        }

        // edge 1---2
        mat.get(1).add(2);
        mat.get(2).add(1);

        // edge u -- v
        // mat.get(u).add(v);
        // mat.get(v).add(u);
        for (int i = 1; i < n; i++) {
            System.out.print(i + "-->");
            for (int j = 0; j < mat.get(i).size(); j++) {
                System.out.println(mat.get(i).get(j));
            }
            System.out.println();
        }

        // using Array --> TC -->  O(n*n)
        // int n = 3;
        // int m = 3;
        // int adj[][] = new int[n+1][n+1];
        // //edge  1--2
        // adj[1][2] = 1;
        // adj[2][1] = 1;
        // // edge 2--3
        // adj[2][3] = 1;
        // adj[3][2] = 1;
        // // edge 1--3
        // adj[1][3] = 1;
        // adj[3][1] = 1;
    }
}
