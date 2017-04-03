/**
 * Created by tgulati on 2/21/17.
 */
public class RepeatedSubstring {

    public static void main(String[] args) {
        RepeatedSubstring obj = new RepeatedSubstring();
        boolean result = obj.repeatedSubstringPattern("ababababa");
        System.out.println(result);
    }

    public boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for (int i = l / 2; i > 0; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(str)) return true;
            }
        }
        return false;
    }
}
