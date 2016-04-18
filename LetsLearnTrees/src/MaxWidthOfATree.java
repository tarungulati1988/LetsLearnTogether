/**
 * Created by tgulati on 4/17/16.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary Tree, write an algorithm to find the maximum width.
 */
public class MaxWidthOfATree {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);

        MaxWidthOfATree i = new MaxWidthOfATree();
        int x = i.findMaxWidth(root);
        System.out.println("Maximum Width of a binary Tree is : " + x);
    }

    private int findMaxWidth(Node root) {
        int maxWidth = 0;
        if (root == null)
            return 0;
        // level order traversal, check for level has changes, before adding
        // to the queue keep width as the queue size, this way only the children would be added
        // if width > maxWidth then assign width to it

        Queue<Node> queue = new LinkedList();
        int width = 0;
        if (root == null) return 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            width = queue.size();
            if (width > maxWidth) {
                maxWidth = width;
            }
            while (width > 0) {
                Node temp = queue.remove();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                width--;
            }
        }
        return maxWidth;

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
