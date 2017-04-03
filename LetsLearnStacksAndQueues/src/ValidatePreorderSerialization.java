import java.util.Stack;

/**
 * Created by tgulati on 2/26/17.
 */
public class ValidatePreorderSerialization {


    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        for (String c : preorder.split(",")) {
            while (c.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(c);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}
