/**
 * Created by tgulati on 1/26/17.
 */
public class ReverseInteger {

    public static void main(String[] args) {

        System.out.println(reverse(123));

    }

    public static int reverse(int x) {
        //flag marks if x is negative
        boolean flag = false;
        if (x < 0) {
            x = 0 - x;
            flag = true;
        }

        int res = 0;
        int p = x;

        while (p > 0) {
            int mod = p % 10;
            p = p / 10;
            res = res * 10 + mod;
        }

        if (flag) {
            res = 0 - res;
        }

        return res;
    }
}
