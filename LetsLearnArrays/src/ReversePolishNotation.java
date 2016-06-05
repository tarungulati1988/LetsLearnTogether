/**
 * Created by tgulati on 6/1/16.
 */

import java.util.Stack;

/**
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {

    public static void main(String[] args) {

        System.out.println(evalRPS(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evalRPS(new String[]{"4", "13", "5", "/", "+"}));

    }

    private static int evalRPS(String[] arr) {

        if(arr == null)
            return 0;

        if(arr.length == 0)
            return 0;

        Stack<String> stack = new Stack<>();

        String operators = "+-*/";

        int result = 0;

        for(String s : arr) {
            if(!operators.contains(s))
                stack.push(s);
            else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());

                switch(s) {
                    case "+":
                        result += a + b;
                        stack.push(String.valueOf(result));
                        break;

                    case "-":
                        result += b - a;
                        stack.push(String.valueOf(result));
                        break;

                    case "*":
                        result += a * b;
                        stack.push(String.valueOf(result));
                        break;

                    case "/":
                        result += b / a;
                        stack.push(String.valueOf(result));
                        break;
                }


            }
        }

        return Integer.valueOf(stack.pop());
    }
}
