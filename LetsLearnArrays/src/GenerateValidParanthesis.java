import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/21/17.
 */
public class GenerateValidParanthesis {

    public static void main(String[] args) {
        GenerateValidParanthesis obj = new GenerateValidParanthesis();
        List<String> result = obj.generateParenthesis(10);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        backtrack(result, n * 2, 0, 0, "", n);
        return result;
    }

    public void backtrack(List<String> result, int size, int open, int close, String str, int n) {
        if (open > n || close > n || close > open) {
            return;
        }
        if (str.length() == size) {
            result.add(str);
            return;
        }
        backtrack(result, size, open + 1, close, str + "(", n);
        backtrack(result, size, open, close + 1, str + ")", n);
    }
}
