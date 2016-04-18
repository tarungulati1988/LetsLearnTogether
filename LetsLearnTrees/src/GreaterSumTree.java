/**
 * Created by tgulati on 4/17/16.
 */
public class GreaterSumTree {
    private int sum = 0;

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print("  " + root.data);
            inorder(root.right);
        }
    }

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        GreaterSumTree treeNode = new GreaterSumTree();
        treeNode.inorder(root);
        System.out.println("");
        treeNode.greaterTree(root);
        treeNode.inorder(root);

    }

    private void greaterTree(Node root) {

        if (root != null) {
            greaterTree(root.right);
            int temp = root.data;
            root.data = sum;
            sum = sum + temp;
            greaterTree(root.left);
        }

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}