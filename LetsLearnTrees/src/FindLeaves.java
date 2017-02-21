import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/18/17.
 */
public class FindLeaves {

    public static void main(String[] args) {

        FindLeaves obj = new FindLeaves();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);

        List<List<Integer>> result = obj.findLeaves(root);
        for(List list : result) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        dfsHelper(root, result);
        return result;
    }

    public int dfsHelper(TreeNode root, List<List<Integer>> result) {
        // base case, solve for final soltuion
        if (root == null) {
            return -1;
        }
        //head recursion
        int left = dfsHelper(root.left, result);
        int right = dfsHelper(root.right, result);
        int level = Math.max(left, right) + 1;

        // if level reached add a new list
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        // add node into the arraylist at index = level
        result.get(level).add(root.val);
        // set the left and right child of the root as null to drop the nodes
        root.left = null;
        root.right = null;

        return level;
    }
}
