/**
 * Created by tgulati on 2/25/17.
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfsHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfsHelper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max) {
            return false;
        }

        if (dfsHelper(root.left, min, root.val) && dfsHelper(root.right, root.val, max)) {
            return true;
        }

        return false;
    }
}
