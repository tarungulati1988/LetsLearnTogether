/**
 * Created by tgulati on 2/24/17.
 */
public class MaximumPathSumBT {

    /**
     * Given a binary tree, find the maximum path sum.

     For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

     For example:
     Given the below binary tree,

       1
      / \
     2   3
     Return 6.
     * @param root
     * @return
     */

    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        if (root == null) {
            return max[0];
        }
        dfsHelper(root, max);
        return max[0];
    }

    public int dfsHelper(TreeNode root, int[] max) {
        if(root == null) {
            return 0;
        }
        int left = dfsHelper(root.left, max);
        int right = dfsHelper(root.right, max);
        int current = Math.max(root.val, Math.max(left + root.val, right + root.val));
        max[0] = Math.max(max[0], Math.max(current, left+right+root.val));
        return current;
    }
}
