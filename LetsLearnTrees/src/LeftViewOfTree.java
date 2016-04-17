/**
 * Created by tgulati on 4/17/16.
 */
public class LeftViewOfTree {

    public static int CURRENT_LEVEL = 0;

    public void leftView(Node root, int nextLevel) {

        if (root == null)
            return;

        if (CURRENT_LEVEL < nextLevel) {
            System.out.println(root.data);
            CURRENT_LEVEL = nextLevel;
        }

        leftView(root.left, nextLevel + 1);
        leftView(root.right, nextLevel + 1);
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.right.left = new Node(30);
        root.right.right = new Node(35);
        root.left.right.right = new Node(45);

        LeftViewOfTree treeObj = new LeftViewOfTree();
        treeObj.leftView(root, 1);

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
