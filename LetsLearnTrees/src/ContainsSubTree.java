/**
 * Created by tgulati on 4/24/16.
 */
public class ContainsSubTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        ContainsSubTree obj = new ContainsSubTree();

        Node root1 = new Node(10);
        root1.left = new Node(5);
        root1.right = new Node(15);
        root1.left.left = new Node(2);
        root1.left.right = new Node(7);
        root1.right.left = new Node(12);
        root1.right.right = new Node(20);

        Node root2 = new Node(5);
        root2.left = new Node(2);
        root2.right = new Node(6);

        System.out.println(obj.containsSubTree(root1, root2));

    }

    private boolean containsSubTree(Node root1, Node root2) {

        if (root2 == null)
            return true;

        return subTree(root1, root2);
    }

    private boolean subTree(Node root1, Node root2) {

        if (root1 == null)
            return false;

        if(root1.data == root2.data)
            if(matchTrees(root1, root2))
                return true;

        return (subTree(root1.left, root2) || subTree(root1.right, root2));
    }

    private boolean matchTrees(Node root1, Node root2) {

        if(root1 == null && root2 == null)
            return true;

        if(root1 == null || root2 == null)
            return false;

        if(root1.data != root2.data)
            return false;

        return (matchTrees(root1.left, root2.left) && matchTrees(root1.right, root2.right));
    }
}
