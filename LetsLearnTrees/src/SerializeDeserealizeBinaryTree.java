import java.util.LinkedList;

/**
 * Created by tgulati on 2/16/17.
 */
public class SerializeDeserealizeBinaryTree {

    public static void main(String[] args) {

        SerializeDeserealizeBinaryTree obj = new SerializeDeserealizeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);

        String serialized = obj.serialize(root);
        System.out.println(serialized);
        TreeNode res = obj.deserialize(serialized);
        System.out.println(res.left.left.val);

    }


    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp != null) {
                queue.offer(temp.left);
                queue.offer(temp.right);
                str.append(temp.val).append(",");
            }


            if (temp == null) {
                str.append("#,");

            }

        }

        return str.deleteCharAt(str.length() - 1).toString();
    }


    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("")) {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp == null) {
                continue;
            }

            if (!arr[i].equals("#")) {
                temp.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(temp.left);
            } else {
                temp.left = null;
                queue.offer(temp.left);
            }
            i++;

            if (!arr[i].equals("#")) {
                temp.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(temp.right);
            } else {
                temp.right = null;
                queue.offer(temp.right);
            }
            i++;
        }

        return root;
    }
}
