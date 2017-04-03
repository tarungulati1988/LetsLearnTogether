import java.util.HashSet;
import java.util.Set;

/**
 * Created by tgulati on 2/28/17.
 */
public class CanPermuteString {

    /**
     * Given a string return a bool if by rearranging
     * its character a permutation could be formed
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}
