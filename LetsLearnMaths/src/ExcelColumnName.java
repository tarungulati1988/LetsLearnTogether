/**
 * Created by tgulati on 1/29/17.
 */
public class ExcelColumnName {

    public static void main(String[] args) {
        System.out.println(getColumnName(27));
    }

    public static String getColumnName(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Blah blah blah");

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;

            char c = (char)(n%26 + 'A');

            n /= 26;
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
