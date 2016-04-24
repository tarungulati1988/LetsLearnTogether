/**
 * Created by tgulati on 4/20/16.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("afasdhgfddfghmomo"));
    }

    public static String longestPalindrome(String str) {
        if (str.isEmpty()) {
            return null;
        }

        if (str.length() == 1) {
            return str;
        }

        String longest = str.substring(0, 1);
        for (int i = 0; i < str.length(); i++) {
            // get longest palindrome with center of i for even length
            String tmp = helper(str, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1 for odd length
            tmp = helper(str, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }

        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    public static String helper(String str, int begin, int end) {
        while (begin >= 0 && end <= str.length() - 1 && str.charAt(begin) == str.charAt(end)) {
            begin--;
            end++;
        }
        return str.substring(begin + 1, end);
    }
}
