/**
 * Created by tgulati on 4/17/16.
 */
public class HeightOfTreeRecursive {

    public int treeHeight(Node root) {
        if (root == null)
            return 0;
        return (1 + Math.max(treeHeight(root.left), treeHeight(root.right)));
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.left.left.left = new Node(30);
        root.left.right.left = new Node(35);
        root.left.right.left.left = new Node(40);
        root.left.right.left.left.right = new Node(45);
        root.left.right.left.left.right.left = new Node(50);
        HeightOfTreeRecursive treeObj = new HeightOfTreeRecursive();
        System.out.println(treeObj.treeHeight(root));
        
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
