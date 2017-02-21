import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/20/17.
 */
public class WordSearch2 {

    public class TrieNode {
        public String word;
        public TrieNode[] next = new TrieNode[26];
    }

    public static void main(String[] args) {
        /**
         [
         ['o','a','a','n'],
         ['e','t','a','e'],
         ['i','h','k','r'],
         ['i','f','l','v']
         ]
         words = ["oath","pea","eat","rain"]
         Return ["eat","oath"]
         */
        WordSearch2 obj = new WordSearch2();
//        List<List<Integer>> result = obj.exist(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
//        for (List list : result) {
//            System.out.println(list.toString());
//        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        TrieNode root = buildTrieNode(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtrack(board, result, root, i, j);
            }
        }
        return result;
    }

    public TrieNode buildTrieNode(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new TrieNode();
                }
                p = p.next[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }

    public void backtrack(char[][] board, List<String> result, TrieNode root, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) {
            return;
        }
        root = root.next[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';

        backtrack(board, result, root, i + 1, j);
        backtrack(board, result, root, i - 1, j);
        backtrack(board, result, root, i, j - 1);
        backtrack(board, result, root, i, j + 1);

        board[i][j] = c;

    }
}
