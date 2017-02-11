/**
 * Created by tgulati on 2/9/17.
 */
public class ClosestNode {


    static int closest;
    static double min = Double.MAX_VALUE;


    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(10);
        root.left.right = new Node(12);
        root.left.right.left = new Node(6);
        root.right.right = new Node(8);
        root.right.right.left = new Node(5);

        System.out.println(closestValue(root, 4));
    }

    public static int closestValue(Node root, double target) {
        helper(root, target);
        return closest;
    }

    public static void helper(Node root, double target) {
        if (root == null)
            return;

        if (Math.abs(root.data - target) < min) {
            min = Math.abs(root.data - target);
            closest = root.data;
        }

        if (target < root.data) {
            helper(root.left, target);
        } else {
            helper(root.right, target);
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
