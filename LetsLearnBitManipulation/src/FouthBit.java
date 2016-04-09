/**
 * Created by tgulati on 4/9/16.
 */

/**
 * Complete the definition of the function int fourthBit(int) so it returns the 4 bit of
 * the 32-bit variable passed to it. The returned integer must be 1 or 0. The code
 * to handle input and output for all the hidden test cases is already
 * written and functioning.
 *
 * Constraints:
 * Given number fits in an integer
 *
 * Input Format:
 * Complete the function "fourthBit" which contains an integer as an argument.
 *
 * Output Format:
 * Return the 4rth bit of the given integer.
 *
 * Sample input #00:
 * 32
 *
 * Sample output #00:
 * 0
 *
 * Sample input #01:
 * 77
 *
 * Sample output #01:
 * 1
 */
public class FouthBit {

    public static void main(String[] args) {
        System.out.println(fourthBit(32));
        System.out.println(fourthBit(77));
    }

    private static int fourthBit(int num) {
        return (num >> 3) & 1;
    }
}
