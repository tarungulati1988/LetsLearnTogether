import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/26/17.
 */
public class FlipGame {

    public static void main(String[] args) {
        FlipGame object = new FlipGame();
        List<String> result = object.generatePossibleNextMoves("+++++++");
        for(String str : result) {
            System.out.println(str);
        }
    }

    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                result.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return result;
    }
}
