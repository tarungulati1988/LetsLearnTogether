/**
 * Created by tgulati on 4/17/16.
 */
public class LeftLeavesSum {
    private static int leftLeavesSum = 0;

    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(10);
        root.left.right = new Node(12);
        root.left.right.left = new Node(6);
        root.right.right = new Node(8);
        root.right.right.left = new Node(5);
        leftSum(root, root);
        System.out.println("Sum of left leaves: " + leftLeavesSum);
    }

    private static void leftSum(Node root, Node parent) {
        if (root != null) {
            leftSum(root.left, root);
            if (root.left == null && root.right == null && parent.left == root)
                leftLeavesSum += root.data;
            leftSum(root.right, root);
        }

    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}