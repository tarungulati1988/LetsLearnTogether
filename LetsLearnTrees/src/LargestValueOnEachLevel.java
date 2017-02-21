import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tgulati on 2/17/17.
 */
public class LargestValueOnEachLevel {

    public static void main(String[] args) {

        LargestValueOnEachLevel obj = new LargestValueOnEachLevel();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);

        List<Integer> result = obj.largestValues(root);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        LinkedList<TreeNode> curr = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        curr.offer(root);
        int max = Integer.MIN_VALUE;

        while(!curr.isEmpty()) {
            TreeNode temp = curr.poll();
            max = Math.max(max, temp.val);
            if(temp.left != null) {
                next.offer(temp.left);
            }
            if(temp.right != null) {
                next.offer(temp.right);
            }

            if(curr.isEmpty()) {
                result.add(max);
                max = Integer.MIN_VALUE;
                curr = next;
                next = new LinkedList<>();

            }

        }
        return result;
    }
}
