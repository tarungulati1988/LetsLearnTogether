/**
 * Created by tgulati on 3/6/17.
 */
public class IsSubSequence {

    public boolean isSubsequence(String s, String t) {
        // s = "abc", t = "ahbgdc"
        if (s.length() == 0) return true;
        int indexS = 0, indexT = 0;
        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }

}
