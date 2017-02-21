/**
 * Created by tgulati on 2/17/17.
 */
public class LongestPalindrome {

    public int max;
    public int lowIndex;

    public static void main(String[] args) {

        LongestPalindrome obj = new LongestPalindrome();
        System.out.println(obj.longestPalindrome("abcbaada"));
    }

    public String longestPalindrome(String s) {


        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            // length is odd therefor single mid
            expandFromMid(s, i, i);
            // length is even therefor 2 mids
            expandFromMid(s, i, i + 1);
        }
        return s.substring(lowIndex, lowIndex + max);
    }

    private void expandFromMid(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            end++;
            start--;

        }
        if (max < end - start - 1) {
            lowIndex = start + 1;
            max = end - start - 1;
        }
    }
}
