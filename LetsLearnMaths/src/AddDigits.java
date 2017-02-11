/**
 * Created by tgulati on 1/26/17.
 */
public class AddDigits {

    public static void main (String[] args) {
        System.out.println(addDigits(89));
    }

    public static int addDigits(int x) {
        int sum = 0;

        while (x > 0) {
            int temp = x%10;
            x = x/10;
            sum+=temp;
        }

        if (sum > 10) {
            return addDigits(sum);
        } else {
            return sum;
        }

    }
}
