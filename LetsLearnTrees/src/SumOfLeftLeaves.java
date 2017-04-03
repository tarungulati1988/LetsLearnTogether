import java.util.LinkedList;

/**
 * Created by tgulati on 2/24/17.
 */
public class SumOfLeftLeaves {


    public static void main(String[] args) {

        SumOfLeftLeaves obj = new SumOfLeftLeaves();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);

        int result = obj.sumOfLeftLeaves(root);
        System.out.println(result);
        System.out.println(obj.sumOfLeftLeavesRecursive(root));
    }

    public int sumOfLeftLeavesRecursive(TreeNode root) {
        int sum = 0;
        if(root == null) {
            return sum;
        }

        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        } else {
            sum += sumOfLeftLeaves(root.left);
        }

        if(root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }

        return sum;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left != null) {
                if (temp.left.left == null && temp.left.right == null) {
                    sum += temp.left.val;
                } else {
                    q.offer(temp.left);
                }
            }
            if (temp.right != null) {
                q.offer(temp.right);
            }
        }
        return sum;
    }
}
