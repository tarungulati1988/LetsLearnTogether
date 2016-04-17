import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tgulati on 4/17/16.
 */

/**
 * Objective: Given a binary Tree, Do Level Order Tra­ver­sal in Zig Zag pat­tern OR Print in Spiral
 * Input: A Binary Tree
 * Output: Order Tra­ver­sal in Zig Zag pat­tern OR Print in Spiral.
 *
 * Time Complexity : O(N)
 */
public class ZigZagTraversal {

    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public static boolean EVEN_LEVEL = false;

    public void levelOrderZigZagQueue(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        int levelNodes = 0;

        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()) {
            levelNodes = queue.size();
            arrayList.clear();
            while (levelNodes > 0) {

                Node node = queue.remove();
                arrayList.add(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                levelNodes--;

            }
            if (EVEN_LEVEL) {
                System.out.println(arrayList);
                EVEN_LEVEL = false;
            } else {
                Collections.reverse(arrayList);
                System.out.println(arrayList);
                EVEN_LEVEL = true;
            }
        }

    }

    public static void main(String[] args) throws java.lang.Exception {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        root.left.left.left = new Node(40);
        root.left.left.right = new Node(45);
        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        System.out.println("ZigZag Traversal: ");
        zigZagTraversal.levelOrderZigZagQueue(root);
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

