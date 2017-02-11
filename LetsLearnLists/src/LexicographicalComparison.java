/**
 * Created by tgulati on 8/14/16.
 */
public class LexicographicalComparison {


    public static void main(String args[]) {

        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);

        Node n2 = new Node(1);
        n2.next = new Node(2);
        n2.next.next = new Node(3);
        n2.next.next.next = new Node(4);
        System.out.println(compareLexicographical(n1, n2));
    }

    private static int compareLexicographical(Node node1, Node node2) {

        if (node1 == null && node2 == null) {
            return 1;
        }
        while (node1 != null && node2 != null && node1.data == node2.data) {
            node1 = node1.next;
            node2 = node2.next;
        }

        if (node1 != null && node2 != null) {
            return (node1.data > node2.data ? 1 : -1);
        }

        if (node1 != null && node2 == null) {
            return 1;
        }
        if (node1 == null && node2 != null) {
            return -1;
        }
        return 0;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
}
