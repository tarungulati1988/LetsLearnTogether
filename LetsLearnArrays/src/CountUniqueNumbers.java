/**
 * Created by tgulati on 3/5/17.
 */
public class CountUniqueNumbers {


    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int result = 10;
        int num = 9;
        for (int i = 2; i <= n && i <= 10; i++) {
            num = num * (9 - i + 2);
            result += num;
        }
        return result;
    }


}
