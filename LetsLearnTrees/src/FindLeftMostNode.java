/**
 * Created by tgulati on 2/24/17.
 */
public class FindLeftMostNode {


    int ans = 0, h = 0;

    public static void main(String[] args) {

        FindLeftMostNode obj = new FindLeftMostNode();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);

        int result = obj.findLeftMostNode(root);
        System.out.println(result);
    }


    public int findLeftMostNode(TreeNode root) {
        findLeftMostNode(root, 1);
        return ans;
    }

    public void findLeftMostNode(TreeNode root, int depth) {
        if (h < depth) {
            ans = root.val;
            h = depth;
        }
        if (root.left != null) findLeftMostNode(root.left, depth + 1);
        if (root.right != null) findLeftMostNode(root.right, depth + 1);
    }
}
