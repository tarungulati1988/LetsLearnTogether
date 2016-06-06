import java.util.HashSet;
import java.util.Set;

/**
 * Created by tgulati on 6/5/16.
 */
public class RemoveDuplicates1 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(7);

        display(head);
        head = deleteDuplicates(head);
        display(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode next_next;

        Set<Integer> set = new HashSet<>();

        if (head == null)
            return head;

        while (current.next != null) {

            int temp = current.data;

            if(set.contains(temp)) {
                next_next = current.next.next;
                current.next = null;
                current.next = next_next;

            } else {
                set.add(temp);
                current = current.next;
            }

        }
        return head;
    }

    public static void display(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println("-----------");
    }


    static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
