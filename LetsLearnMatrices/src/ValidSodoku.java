/**
 * Created by tgulati on 6/5/16.
 */
public class ValidSodoku {

    public static void main(String[] args) {
        // isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {

        if(board == null || board.length == 0 || board[0].length == 0 || board.length < 9 || board.length > 9 || board[0].length < 9 || board[0].length > 9)
            return false;

        // check each row
        for(int i  = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(row[(int)board[i][j] - '1']) {
                        return false;
                    }
                    row[(int)board[i][j] - '1'] = true;
                }
            }
        }

        // check each column
        for(int j  = 0; j < 9; j++) {
            boolean[] col = new boolean[9];
            for(int i = 0; i < 9; i++) {
                if(board[i][j] != '.') {
                    if(col[(int)board[i][j] - '1']) {
                        return false;
                    }
                    col[(int)board[i][j] - '1'] = true;
                }
            }
        }

        // check each cube
        for (int block = 0; block < 9; block++) {
            boolean[] cube = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (cube[(int) (board[i][j] - '1')]) {
                            return false;
                        }
                        cube[(int) (board[i][j] - '1')] = true;
                    }
                }
            }
        }

        return true;

    }
}
