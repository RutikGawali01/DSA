class  Board{
    char[][] board = new char[9][9];
}

public class SudokuSolver {

    public static boolean isValid(Board b, char c, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if (b.board[row][i] == c) {
                return false;
            }

            if (b.board[i][col] == c) {
                return false;
            }

            if (b.board[3 * (row / 3) + ( i / 3 ) ][3 * (col / 3) + (i % 3)] == c) {
                return false;
            }

        }
        return true;
    }

    public static boolean Sudoku_Solver(Board b) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b.board[i][j] == '-') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(b, c, i, j)) {
                            b.board[i][j] = c;
                            if (Sudoku_Solver(b)) {
                                return true;
                            } else {
                                b.board[i][j] = '-';
                            }
                        }
                        
                    }
                    return false;
                }
            }
            
        }
        
        return true;
    }

    public static void main(String[] args) {
        Board b = new Board();


        // char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                b.board[i][j] = '-';
            }
        }

        b.board[0][0] = '5';
        b.board[0][1] = '3';
        b.board[0][3] = '6';
        b.board[0][4] = '7';
        b.board[0][5] = '8';
        b.board[0][6] = '9';
        b.board[0][8] = '2';

        b.board[1][0] = '6';
        b.board[1][1] = '7';
        b.board[1][2] = '2';
        b.board[1][3] = '1';
        b.board[1][4] = '9';
        b.board[1][5] = '5';
        b.board[1][6] = '3';
        b.board[1][7] = '4';
        b.board[1][8] = '8';

        b.board[2][1] = '9';
        b.board[2][2] = '8';
        b.board[2][3] = '3';
        b.board[2][4] = '4';
        b.board[2][5] = '2';
        b.board[2][6] = '5';
        b.board[2][7] = '6';
        b.board[2][8] = '7';

        b.board[3][0] = '8';
        b.board[3][1] = '5';
        b.board[3][2] = '4';
        b.board[3][3] = '7';
        b.board[3][4] = '6';
        b.board[3][5] = '1';
        b.board[3][6] = '4';
        b.board[3][7] = '2';
        b.board[3][8] = '3';

        b.board[4][0] = '4';
        b.board[4][1] = '2';
        b.board[4][2] = '6';
        b.board[4][3] = '8';
        b.board[4][4] = '5';
        b.board[4][5] = '3';
        b.board[4][6] = '7';
        b.board[4][7] = '9';
        b.board[4][8] = '1';

        b.board[5][0] = '7';
        b.board[5][1] = '1';
        b.board[5][2] = '3';
        b.board[5][3] = '9';
        b.board[5][5] = '4';
        b.board[5][6] = '8';
        b.board[5][7] = '5';
        b.board[5][8] = '6';

        b.board[6][0] = '9';
        b.board[6][1] = '6';
        b.board[6][3] = '5';
        b.board[6][4] = '3';
        b.board[6][5] = '7';
        b.board[6][6] = '2';
        b.board[6][7] = '8';
        b.board[6][8] = '4';

        b.board[7][0] = '2';
        b.board[7][1] = '8';
        b.board[7][2] = '7';
        b.board[7][3] = '4';
        b.board[7][4] = '1';
        b.board[7][5] = '9';
        b.board[7][6] = '6';
        b.board[7][7] = '3';
        b.board[7][8] = '5';

        b.board[8][0] = '3';
        b.board[8][1] = '4';
        b.board[8][2] = '5';
        b.board[8][3] = '2';
        b.board[8][4] = '8';
        b.board[8][5] = '6';
        b.board[8][6] = '1';
        b.board[8][7] = '7';
        b.board[8][8] = '9';


        Sudoku_Solver(b);

        for(int i = 0 ; i< 9 ; i++){
            for(int j = 0; j< 9 ; j++){
                System.out.print(b.board[i][j] + " ");
            }
            System.out.println();
        }

        
    }
}
