/**
 * Created by tgulati on 6/5/16.
 */
public class ReverseVowels {

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello world"));
    }

    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] cs = s.toCharArray();

        int start = 0;
        int end = cs.length - 1;

        while (start < end) {

            while (start < end && !isVowel(cs[start])) {
                start++;
            }

            while (start < end && !isVowel(cs[end])) {
                end--;
            }

            if (start < end) {
                swap(cs, start, end);
                start++;
                end--;
            }
        }

        return new String(cs);
    }

    private static boolean isVowel(char b) {
        char c = Character.toLowerCase(b);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static void swap(char[] cs, int start, int end) {
        char temp = cs[start];
        cs[start] = cs[end];
        cs[end] = temp;
    }
}
