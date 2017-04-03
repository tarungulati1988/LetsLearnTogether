/**
 * Created by tgulati on 2/28/17.
 */
public class AddTwoNumbers {

    public String addStrings(String num1, String num2) {
        if ((num1 == null || num1.length() == 0) && (num2 == null || num2.length() == 0)) {
            return "";
        }
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int x = (i >= 0 ? num1.charAt(i) - '0' : 0);
            int y = (j >= 0 ? num2.charAt(j) - '0' : 0);
            i--;
            j--;
            int sum = x + y + carry;
            int number = sum % 10;
            sb.append(number);
            carry = sum / 10;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
