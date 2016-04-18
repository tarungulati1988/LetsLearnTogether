/**
 * Created by tgulati on 4/17/16.
 */
public class ConvertToSumTree {

    private static Node newRoot;

    public void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(root.data + "  ");
            display(root.right);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(5);
        root.left = new Node(-1);
        root.right = new Node(3);
        root.left.left = new Node(-2);
        root.left.right = new Node(4);
        root.right.left = new Node(-6);
        root.right.right = new Node(10);
        ConvertToSumTree treeNode = new ConvertToSumTree();
        System.out.print("Original Tree: ");
        treeNode.display(root);
        System.out.print("\nSum tree: ");
        treeNode.sum(root);
        //Print the new tree
        treeNode.display(newRoot);
    }

    private int sum(Node root) {
        if (root != null) {
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            int result = root.data + leftSum + rightSum;
            root.data = leftSum + rightSum;
            newRoot = root;
            return result;

        }

        return 0;

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
