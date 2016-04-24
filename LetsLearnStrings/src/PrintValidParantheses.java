/**
 * Created by tgulati on 4/17/16.
 */

/**
 * Print all combinations of balanced parentheses
 * Write a function to generate all possible n pairs of balanced parentheses.
 * For example, if n=1
 * {}
 * for n=2
 * {}{}
 * {{}}
 */
public class PrintValidParantheses {

    public static void main(String[] args) {

        printParantheses(3, 0, "");
    }

    private static void printParantheses(int left, int right, String str) {
        if (left == 0 && right == 0) {
            System.out.println(str);
        }

        if (left > 0) {
//            System.out.println("left>0: " + str);
            printParantheses(left - 1, right + 1, str + "{");
        }
        if (right > 0) {
//            System.out.println("right>0: " + str);
            printParantheses(left, right - 1, str + "}");
        }

    }


}

