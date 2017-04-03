import java.util.List;

/**
 * Created by tgulati on 3/6/17.
 */
public class VerifyValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }
        int n = words.size();
        for (int i = 0; i < n; i++) {
            if (words.get(i).length() > n) {
                return false;
            }
            for (int j = 0; j < words.get(i).length(); j++) {
                if (words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
