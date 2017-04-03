import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgulati on 2/24/17.
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        dfsHelper(root, result, new ArrayList<>(), sum);
        return result;
    }

    public void dfsHelper(TreeNode root, List<List<Integer>> result, ArrayList<Integer> tempList, int sum) {
        if (root == null) {
            return;
        }
        tempList.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        }

        dfsHelper(root.left, result, tempList, sum - root.val);
        dfsHelper(root.right, result, tempList, sum - root.val);
        tempList.remove(tempList.size() - 1);
    }
}
