/**
 * Created by tgulati on 6/5/16.
 */

/**
 * Given a linked list and a value x, partition it such that all nodes
 * less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 */
public class PartitionList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(7);

        display(head);
        head = partitionList(head, 3);
        display(head);
    }

    private static ListNode partitionList(ListNode head, int k) {

        if(head == null)
            return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;
        ListNode prev = fakeHead1;
        ListNode l = fakeHead2;

        while(head != null){
            if(head.data < k){
                head = head.next;
                prev = prev.next;
            }else{
                l.next = head;
                prev.next = head.next;

                head = prev.next;
                l = l.next;
            }
        }

        l.next = null;
        prev.next = fakeHead2.next;

        return fakeHead1.next;

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
