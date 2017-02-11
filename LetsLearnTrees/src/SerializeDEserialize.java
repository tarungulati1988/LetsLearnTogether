import java.util.LinkedList;

/**
 * Created by tgulati on 2/10/17.
 */

/**
 * Use level order traversal for serializing and deserializing
 * all null nodes should be represented as # this includes the leaf nodes
 */
public class SerializeDeserialize {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        System.out.println(serialize(root));

        Node res = deserialize(serialize(root));

        System.out.println(res.data);
        System.out.println(res.left.data);
        System.out.println(res.right.data);


    }


    public static String serialize(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node t = queue.poll();
            if (t != null) {
                sb.append(String.valueOf(t.data) + ",");
                queue.add(t.left);
                queue.add(t.right);
            } else {
                sb.append("#,");
            }
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static Node deserialize(String str) {
        String[] arr = str.split(",");
        Node root = new Node(Integer.parseInt(arr[0]));
        LinkedList<Node> q = new LinkedList<>();
        int i = 1;
        q.add(root);

        while (!q.isEmpty()) {

            Node temp = q.poll();
            if (temp == null) {
                continue;
            }

            if (!arr[i].equals("#")) {
                temp.left = new Node(Integer.parseInt(arr[i]));
                q.add(temp.left);
            } else {
                temp.left = null;
                q.add(null);
            }
            i++;

            if (!arr[i].equals("#")) {
                temp.right = new Node(Integer.parseInt(arr[i]));
                q.add(temp.right);
            } else {
                temp.right = null;
                q.add(null);
            }
            i++;
        }

        return root;
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
