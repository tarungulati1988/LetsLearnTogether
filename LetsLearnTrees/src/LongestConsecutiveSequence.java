
import java.util.LinkedList;

/**
 * Created by tgulati on 2/5/17.
 */
public class LongestConsecutiveSequence {


    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(6);
        root.right = new Node(15);
        root.left.left = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        root.left.right.right = new Node(45);

        System.out.println(consecutiveSequenceLength(root));

    }

    public static int consecutiveSequenceLength(Node root) {
        if (root == null) {
            return 0;
        }

        LinkedList<Node> nodes = new LinkedList<>();
        LinkedList<Integer> size = new LinkedList<>();

        int max = 1;
        nodes.offer(root);
        size.offer(1);
        while (!nodes.isEmpty()) {
            Node temp = nodes.poll();
            int s = size.poll();

            if(temp.left != null) {
                int leftSize = s;
                if(temp.data == temp.left.data -1) {
                    leftSize++;
                    max = Math.max(max, leftSize);
                } else {
                    leftSize = 1;
                }
                nodes.offer(temp.left);
                size.offer(leftSize);
            }


            if(temp.right != null) {
                int rightSize = s;
                if(temp.data == temp.right.data + 1) {
                    rightSize++;
                    max = Math.max(max, rightSize);
                } else {
                    rightSize = 1;
                }
                nodes.offer(temp.right);
                size.offer(rightSize);
            }

        }

        return max;
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
