/**
 * Created by tgulati on 8/13/16.
 */
public class FindStrictlyIncreasing {

    public static void main(String s[]) {
        int n = 3;
        findStrictlyIncreasingNum(0, "", n);
    }

    private static void findStrictlyIncreasingNum(int start, String out, int n) {
        if (n == 0) {
            System.out.println(out);
            return;
        }

        // start from (prev digit + 1) till 9
        for (int i = start; i <= 9; i++) {
            // append current digit to number
            String str = out + String.valueOf(i);

            // recurse for next digit
            findStrictlyIncreasingNum(i + 1, str, n - 1);
        }
    }
}
