import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by tgulati on 2/11/17.
 */
public class MergeKLists {


    public static void main(String args[]) {
        ListNode[] lists = new ListNode[3];
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(5);
        lists[0] = n;
        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);
        lists[1] = n2;

        ListNode n3 = new ListNode(10);
        n3.next = new ListNode(11);
        n3.next.next = new ListNode(22);
        lists[2] = n3;

        ListNode result = mergeKLists(lists);
        System.out.println(result.data);

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.data - o2.data;
            }

        });

        for (ListNode list : lists) {
            if (list != null) {
                q.offer(list);
            }
        }

        ListNode head = new ListNode(0);
        ListNode p = head;

        while (!q.isEmpty()) {
            ListNode temp = q.poll();
            p.next = temp;
            p = p.next;

            if (temp.next != null) {
                q.offer(temp.next);
            }
        }

        return head.next;
    }

}
