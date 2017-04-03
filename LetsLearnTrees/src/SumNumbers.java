/**
 * Created by tgulati on 3/7/17.
 */
public class SumNumbers {

    public static void main(String[] args) {

        SumNumbers obj = new SumNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        root.left.left = new TreeNode(4);

        int result = obj.sumNumbers(root);
        System.out.println(result);
    }


    int[] sum = new int[1];
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        sum[0] = 0;
        sum(root, 0);
        return sum[0];
    }

    public void sum(TreeNode root, int num)  {
        if(root == null) {
//            sum[0] += num;
            return;
        }

        if(root.right == null && root.left == null) {
            sum[0] += num*10+ root.val;
        }
//        if(root.left != null)
            sum(root.left, num*10+ root.val);
//        if(root.right != null)
            sum(root.right, num*10+ root.val);

    }
}
