
public class Surrounded_Region__Replace_Os_to_Xs {

    public static void dfs(int ro, int co, char[][] board, boolean[][] vis, int[] delRow, int[] delCol) {
        vis[ro][co] = true;
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nro = ro + delRow[i];
            int nco = co + delCol[i];

            if (nro < n && nro >= 0 && nco < m && nco >= 0 && vis[nro][nco] != true && board[nro][nco] == 'O') {
                dfs(nro, nco, board, vis, delRow, delCol);
            }
        }

    }

    public static void replace(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};

        boolean[][] vis = new boolean[n][m];

        for (int j = 0; j < m; j++) {
            // first row
            if (!vis[0][j] && board[0][j] == 'O') {
                dfs(0, j, board, vis, delRow, delCol);
            }

            // last row 
            if (!vis[n - 1][j] && board[n - 1][j] == 'O') {
                dfs(n - 1, j, board, vis, delRow, delCol);
            }
        }

        for (int i = 0; i < n; i++) {
            // first column
            if (!vis[i][0] && board[i][0] == 'O') {
                dfs(i, 0, board, vis, delRow, delCol);
            }
            // last column
            if (!vis[i][m - 1] && board[i][m - 1] == 'O') {
                dfs(i, m - 1, board, vis, delRow, delCol);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }

    public static void main(String[] args) {

    }

}
