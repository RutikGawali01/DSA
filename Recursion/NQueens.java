
import java.util.*;

 class Solution{
         public static boolean isSafe(int row, int col, int n, ArrayList<ArrayList<String>> board) {
        int r = row;
        int c = col;

        //uppper diagonal 
        while (row >= 0 && col >= 0) {
            if (board.get(row).get(col) == "Q") {
                return false;
            }
            row--;
            col--;
        }

        row = r;
        col = c;
        // right side positions
        while (col >= 0) {
            if (board.get(row).get(col) == "Q") {
                return false;
            }
            col--;
        }

        // lower diagonal 
        row = r;
        col = c;
        while (row < n && col >= 0) {
            if (board.get(row).get(col) == "Q") {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    public static void validBoard(int col, int n, ArrayList<ArrayList<String>> board, ArrayList<ArrayList<ArrayList<String>>> res) {
        if(col == n){
            //System.out.println(board);
            res.add(board);
            return;
        }
        for (int row = 0; row < n; row++) {
            boolean temp = isSafe(row, col, n, board);
            if (isSafe(row, col, n, board)) {
                board.get(row).set(col, "Q");
                validBoard(col + 1, n, board, res);
                board.get(row).set(col, "-");
            }

        }

    }
    
    }

public class NQueens {
    public static void printArray(char [][] board){
            for(int i = 0 ; i<board.length ; i++){
                for(int j = 0 ; j < board.length ; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("--end");
    }
    public static void NQueenOptimal( char [][] board, int col,int n , int[] leftRow , int[] lowerDiagonal , int[] upperDiagonal){
             if(col == n){
                printArray(board);
                return;
             }
            for(int row = 0; row< n ; row++){
                if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[(n-1)+row-col] == 0){
                    board[row][col] = 'Q';
                    leftRow[row] =1;
                    lowerDiagonal[row+col] = 1;
                    upperDiagonal[(n-1)+row-col] = 1;
                    NQueenOptimal(board, col+1, n, leftRow, lowerDiagonal, upperDiagonal);
                    board[row][col] = '-';
                    leftRow[row] = 0;
                    lowerDiagonal[row+col] = 0;
                    upperDiagonal[(n-1)+row-col] = 0;
                }
            }

    }




    public static void main(String[] args) {
        // ArrayList<ArrayList<String>> board = new ArrayList<>(4);
        int n = 4;
        // for (int i = 0; i < n; i++) {
        //         ArrayList<String> temp = new ArrayList<>();
        //     for (int j = 0; j < n; j++) {
        //         temp.add("-");
        //     }
        //      board.add(temp);
        // }
        // //System.out.println(board);
        // ArrayList<ArrayList<ArrayList<String>>> res = new ArrayList<>();
        // Solution s   = new Solution();
        // s.validBoard(0, 4, board, res);
        //  System.out.println(res);
         //System.out.println(board);

        char [][] board = new char[n][n];
        // Arrays.fill(board, '-');
        
        int[] leftRow = new int[n];

        int[] lowerDiagonal  = new int[2*n-1];

        int[] upperDiagonal = new int[2*n -1];

        NQueenOptimal(board,0,n,leftRow, lowerDiagonal,upperDiagonal);


    }
}
