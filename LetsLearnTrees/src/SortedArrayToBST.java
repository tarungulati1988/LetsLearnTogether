/**
 * Created by tgulati on 5/1/16.
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        SortedArrayToBST outputTree = new SortedArrayToBST();
        String[] sortedArr = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        inorderTraversal(outputTree.getBST(sortedArr));
    }

    private static void inorderTraversal(TreeNode root) {
        if(root != null) {
            inorderTraversal(root.left);
            System.out.println(root.val);
            inorderTraversal(root.right);
        }
    }

    private TreeNode getBST(String[] sortedArr) {

        if(sortedArr == null)
            return null;

        return getSortedArrayToBST(sortedArr, 0, sortedArr.length-1);
    }

    private TreeNode getSortedArrayToBST(String[] sortedArr, int start, int end) {

        if(start > end)
            return null;

        int mid = (start + end)/2;
        TreeNode root = new TreeNode(Integer.parseInt(sortedArr[mid]));
        root.left = getSortedArrayToBST(sortedArr, start, mid-1);
        root.right = getSortedArrayToBST(sortedArr, mid+1, end);

        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
