import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tgulati on 4/17/16.
 */

/**
 * Objective: Given a binary Tree, Do Level Order Tra­ver­sal
 *
 * Time Complexity : O(N)
 */
public class LevelOrderTraversal {

    public void levelOrderQueue(Node root) {
        Queue<Node> queue = new LinkedList<Node>();

        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()) {

            Node node = queue.remove();
            System.out.println(node.data);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        root.left.left.left = new Node(40);
        root.left.left.right = new Node(45);
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        System.out.println(" Level order traversal: ");
        levelOrderTraversal.levelOrderQueue(root);
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

