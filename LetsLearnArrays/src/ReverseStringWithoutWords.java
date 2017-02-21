/**
 * Created by tgulati on 2/16/17.
 */
public class ReverseStringWithoutWords {
    public static String str = "the sky is blue";

    public static void main(String[] args) {
        ReverseStringWithoutWords obj = new ReverseStringWithoutWords();

        obj.reverseWords(str.toCharArray());
        System.out.println(str);
    }

    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        reverse(s, 0, s.length-1);
        int start = 0;

        for(int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i-1);
                start = i + 1;
            }
        }
        reverse(s, start, s.length-1);
        str = String.copyValueOf(s);
    }

    public void reverse(char[]s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
