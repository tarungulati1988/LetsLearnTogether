import java.util.HashSet;
import java.util.Set;

/**
 * Created by tgulati on 3/6/17.
 */
public class LongestPalindromeThatCanBeCreated {

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }

        if (!set.isEmpty()) {
            return count * 2 + 1;
        } else {
            return count * 2;
        }
    }
}
