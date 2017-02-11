import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by tgulati on 5/26/16.
 */
public class ReverseLinkedListInRange {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        display(head);

        //head = reverse(head, 3, 5);
        head = reverse2(head, 3, 5);


        display(head);
    }

    private static Node reverse2(Node head, int m, int n) {

        if (head == null || head.next == null || m == n) {
            return head;
        }
        Node dummy = new Node(0);
        Node first = dummy;
        dummy.next = head;

        for (int i = 0; i < m-1; i++) {
            first = first.next;
        }

        System.out.println("first: ");
        display(first);

        Node cur = first.next;
        Node prev = first.next;
        Node node = null;

        for (int i = 0; i <= n-m; i++) {
            Node nxt = cur.next;
            cur.next = node;
            node = cur;
            cur = nxt;
        }
//        System.out.println("first2: ");
//        display(first);
//
//        System.out.println("prev:");
//        display(prev);
//
//        System.out.println("curr:");
//        display(cur);
//
//        System.out.println("node:");
//        display(node);

        prev.next = cur;
        System.out.println("prev:");
        display(prev);

        first.next = node;

        return dummy.next;
    }

    public static void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println("-----------");
    }

    private static Node reverse(Node head, int start, int end) {
        if (head == null)
            return null;

        for (int k = 0; k < start - 1; k++) {
            head = head.next;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
//        for (int i = start; i < end-1 ; i++) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }

        head = prev;


        return head;
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
