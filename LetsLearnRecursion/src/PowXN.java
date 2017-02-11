/**
 * Created by tgulati on 6/29/16.
 */
public class PowXN {

    public static void main(String... args) {
        System.out.println(pow(3,3));

    }

    public static int pow(int x, int n) {

        if(n == 0) return 1;

        return x * pow(x, n-1);

    }
}
