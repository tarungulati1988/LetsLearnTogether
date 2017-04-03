import java.util.Stack;

/**
 * Created by tgulati on 3/6/17.
 */
public class VerifyPreorderTraversal {

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int p : preorder) {
            if (p < min) {
                return false;
            }
            while (!stack.isEmpty() && p > stack.peek()) {
                min = stack.pop();
            }
            stack.push(p);
        }
        return true;
    }
}
