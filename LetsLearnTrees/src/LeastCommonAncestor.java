/**
 * Created by tgulati on 4/24/16.
 */
public class LeastCommonAncestor {


    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(12);
        root.right.right = new Node(20);

        Node temp = findLCA(root, 2, 7);

        if (temp != null)
            System.out.println(temp.data);
    }

    private static Node findLCA(Node root, int n1, int n2) {
        if(root == null)
            return null;

        if(root.data == n1 || root.data == n2)
            return root;

        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }
}
