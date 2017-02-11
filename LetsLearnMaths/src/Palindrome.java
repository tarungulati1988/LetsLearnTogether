/**
 * Created by tgulati on 1/26/17.
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1234321));
    }

    public static boolean isPalindrome(int x) {

        // max and min checks
        if (x < 0)
            return false;

        int div = 1;

        while(x/div >= 10) {
            div *= 10;
        }
        // get length and then 10^length

        while(x > 0) {
            int left = x/div;
            int right = x%10;

            if (left != right)
                return false;

            int temp = x%div;
            x = temp/10;
            div /= 100;
        }

        return true;

    }
}
