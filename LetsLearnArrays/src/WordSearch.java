import java.util.List;

/**
 * Created by tgulati on 2/20/17.
 */
public class WordSearch {

    public static void main(String[] args) {
        /**
         * [
         ['A','B','C','E'],
         ['S','F','C','S'],
         ['A','D','E','E']
         ]
         word = "ABCCED", -> returns true,
         word = "SEE", -> returns true,
         word = "ABCB", -> returns false.
         */
        WordSearch obj = new WordSearch();
//        List<List<Integer>> result = obj.exist(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
//        for (List list : result) {
//            System.out.println(list.toString());
//        }
    }


    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word.equals("")) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exists(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exists(char[][] board, int i, int j, int start, String word) {
        if (start >= word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (board[i][j] == word.charAt(start)) {
            start++;
            char temp = board[i][j];
            board[i][j] = '#';
            boolean result = false;
            result = exists(board, i + 1, j, start, word) || exists(board, i - 1, j, start, word) || exists(board, i, j + 1, start, word) || exists(board, i, j - 1, start, word);
            board[i][j] = temp;
            return result;
        }
        return false;
    }
}
