/**
 * Created by tgulati on 5/26/16.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        display(head);

        head = reverse(head);

        display(head);
    }

    public static void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println("-----------");
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
//        head = prev;
        return prev;
    }

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
