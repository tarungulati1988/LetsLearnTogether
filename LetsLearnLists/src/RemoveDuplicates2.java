import java.util.HashMap;
import java.util.Map;

/**
 * Created by tgulati on 6/5/16.
 */
public class RemoveDuplicates2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(4);

        display(head);
        head = deleteDuplicates(head);
        display(head);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;

        if(head.next == null)
            return head;

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode prev = res, curr = head;
        int count = 1;

        while(curr.next != null) {
            if(curr.next.val == curr.val) {
                count++;
            } else {
                if(count == 1) {
                    prev.next = curr;
                    prev = curr;
                } else {
                    count = 1;
                }
            }
            curr = curr.next;
        }

        if(count == 1)
            prev.next = curr;
        else
            prev.next = null;

        return res.next;
    }

    public static void display(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(" " + curr.val);
            curr = curr.next;
        }
        System.out.println("-----------");
    }

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
