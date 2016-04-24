/**
 * Created by tgulati on 4/19/16.
 */
public class SumTillLeaf {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
//        Node root = new Node(5);
//        root.left = new Node(10);
//        root.right = new Node(15);
//        root.left.left = new Node(20);
//        root.left.right = new Node(25);
//        root.right.left = new Node(30);
//        root.right.right = new Node(35);
//        root.left.left.left = new Node(40);
//        root.left.left.right = new Node(45);
        SumTillLeaf obj = new SumTillLeaf();
        System.out.println("Sum: ");
        System.out.println(obj.sumNumbers(root));


    }

    private int sumNumbers(Node root) {

        if (root == null)
            return 0;
        return dfs(root, 0, 0);
    }

    private int dfs(Node root, int num, int sum) {
        if(root == null)
            return sum;

        num = num*10 + root.data;

        //for leafs
        if (root.left == null && root.right == null) {
            sum += num;
            return sum;
        }

        // now add left sub tree and the right sub tree
        sum = dfs(root.left, num, sum) + dfs(root.right, num, sum);

        return sum;

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
