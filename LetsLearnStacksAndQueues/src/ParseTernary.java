import java.util.Stack;

/**
 * Created by tgulati on 2/26/17.
 */
public class ParseTernary {

    public static void main(String[] args) {
        ParseTernary object = new ParseTernary();
        String result = object.parseTernary("T?T?T:5:3");
        System.out.println(result);
    }

    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                // remove ?
                stack.pop();
                char first = stack.pop();
                // remove :
                stack.pop();
                char second = stack.pop();
                if (c == 'T') {
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {
                stack.push(c);
            }
        }
        return String.valueOf(stack.peek());
    }
}
