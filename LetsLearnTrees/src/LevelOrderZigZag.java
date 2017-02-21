import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tgulati on 2/18/17.
 */
public class LevelOrderZigZag {

    public static void main(String[] args) {

        LevelOrderZigZag obj = new LevelOrderZigZag();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);

        List<List<Integer>> result = obj.zigzagLevelOrder(root);
        for(List list : result) {
            System.out.println(list.toString());
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> curr = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        List<Integer> tempResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        curr.offer(root);

        boolean isEven = false;
        while(!curr.isEmpty()) {
            TreeNode temp = curr.poll();
            tempResult.add(temp.val);

                if(temp.left != null) {
                    next.offer(temp.left);
                }
                if(temp.right != null) {
                    next.offer(temp.right);
                }


            if(curr.isEmpty()) {
                if(isEven) {
                    Collections.reverse(tempResult);
                    result.add(tempResult);
                } else {
                    result.add(tempResult);
                }
                tempResult = new ArrayList<>();
                curr = next;
                next = new LinkedList<>();
                isEven = !isEven;
            }

        }
        return result;
    }
}
