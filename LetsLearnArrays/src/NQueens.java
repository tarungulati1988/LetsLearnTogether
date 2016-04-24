/**
 * Created by tgulati on 4/24/16.
 */
public class NQueens {

    public static int N = 8;

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        nq.solveNQueens();
    }

    private void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++)
                System.out.print(board[row][col] + "  ");
            System.out.println();
        }
    }

    public boolean isSafeToPlace(int board[][], int row, int col) {

        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // check the upper diagonal on the left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // check the lower diagonal on the left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public boolean solveNQueens(int board[][], int col) {
        // if all the queens are placed then return true
        if (col >= N)
            return true;

        // for this column place queen in all the rows and test
        for (int i = 0; i < N; i++) {
            // check if the queen can be places in board[i][col]
            if (isSafeToPlace(board, i, col)) {
                board[i][col] = 1;
                // recursively check if other queens can be placed
                if (solveNQueens(board, col + 1))
                    return true;
                // if board[i][col] doesn't lead to a solution then reset it
                board[i][col] = 0;
            }
        }

        return false;
    }

    public boolean solveNQueens() {
//        int board[][] = {{0, 0, 0, 0},
//                         {0, 0, 0, 0},
//                         {0, 0, 0, 0},
//                         {0, 0, 0, 0}};

        int[][] board = {{0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0}};

        if (solveNQueens(board, 0)) {
            printBoard(board);
            return true;
        }

        System.out.print("INVALID");
        return false;
    }

}
