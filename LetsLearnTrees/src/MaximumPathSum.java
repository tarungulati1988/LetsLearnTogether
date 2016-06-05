/**
 * Created by tgulati on 5/1/16.
 */
public class MaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(7);
//        root.right.left = new TreeNode(12);
//        root.right.right = new TreeNode(20);

//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(10);
//        root.right = new TreeNode(15);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(7);
//        root.right.left = new TreeNode(12);
//        root.right.right = new TreeNode(20);

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(10);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left.left = new TreeNode(20);
        root.left.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);


        MaximumPathSum obj = new MaximumPathSum();
        System.out.println(obj.maxPathSum(root));

    }


    public int maxPathSum(TreeNode root) {

        if (root == null)
            return 0;

        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }

    public int calculateSum(TreeNode root, int[] max) {

        if (root == null)
            return 0;

        int left = calculateSum(root.left, max);
        int right = calculateSum(root.right, max);

        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));

        max[0] = Math.max(max[0], Math.max(current, left + root.val + right));

        return current;
    }
}
