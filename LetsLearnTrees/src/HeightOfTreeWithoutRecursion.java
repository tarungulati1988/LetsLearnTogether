import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tgulati on 4/17/16.
 */
public class HeightOfTreeWithoutRecursion {

    public int getHeight(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        int height = 0;

        queue.add(root);
        queue.add(null);
        // to mark end of level

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            // if node is null then end f level has been reached, increment level by 1
            // else keep add the children
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                height++;
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(8);

        HeightOfTreeWithoutRecursion treeObj = new HeightOfTreeWithoutRecursion();
        System.out.println("Tree Height: " + treeObj.getHeight(root));

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

