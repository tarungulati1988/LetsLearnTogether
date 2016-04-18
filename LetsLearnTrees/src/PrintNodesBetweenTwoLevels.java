import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tgulati on 4/17/16.
 */

/**
 * Objective: Given a binary Tree and two levels, Print all the nodes between those.
 * Input: A Binary Tree and two levels.
 * Output: Print all the nodes between given levels.
 */
public class PrintNodesBetweenTwoLevels {

    public static int CURRENT_LEVEL = 1;

    public void levelOrderZigZagQueue(Node root, int low, int high) {

        Queue<Node> queue = new LinkedList<Node>();
        int levelNodes = 0;

        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()) {

            levelNodes = queue.size();

            while (levelNodes > 0) {

                Node node = queue.remove();
                if (CURRENT_LEVEL >= low && CURRENT_LEVEL <= high) {
                    System.out.print(" " + node.data);
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

                levelNodes--;

            }
            CURRENT_LEVEL++;
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
        root.left.right.left = new Node(40);
        root.left.right.right = new Node(45);
        root.left.right.left.left = new Node(50);
        PrintNodesBetweenTwoLevels treeObj = new PrintNodesBetweenTwoLevels();
//        System.out.println("Nodes: ");
//        treeObj.levelOrderZigZagQueue(root, 2, 3);

        System.out.println("Nodes: ");
        treeObj.levelOrderZigZagQueue(root, 2, 4);

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
