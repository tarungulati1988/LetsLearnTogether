/**
 * Created by tgulati on 4/17/16.
 */
public class DeleteTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        deleteTree(root);
    }

    private static Node deleteTree(Node root) {
        if (root != null) {
            deleteTree(root.left);
            deleteTree(root.right);
            System.out.println("node deleted: " + root.data);
            root = null;
            return root;
        }
        return null;
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