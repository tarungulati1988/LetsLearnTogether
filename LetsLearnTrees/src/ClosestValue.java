/**
 * Created by tgulati on 2/24/17.
 */
public class ClosestValue {

    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - result)) {
                result = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return result;

    }
}
