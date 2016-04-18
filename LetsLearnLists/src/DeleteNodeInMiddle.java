/**
 * Created by tgulati on 4/17/16.
 */
/**
 * Write a pro­gram to Delete a Node in the Mid­dle of a linked list, Given only access to that Node
 */
public class DeleteNodeInMiddle {

    public void deleteMiddle(Node mid) {

        if(mid.next == null)
            return;

        Node temp = mid;
        temp.data = mid.next.data;
        temp.next = mid.next.next;
//        System.out.println("temp"+temp.data);

    }

    public void display(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(" " + n.data);
            n = n.next;
        }
    }

    public static void main(String args[]) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(8);
        n.next.next.next = new Node(3);
        Node mid = new Node(7);
        n.next.next.next.next = mid;
        n.next.next.next.next.next = new Node(0);
        n.next.next.next.next.next.next = new Node(4);
        System.out.println("list: ");
        DeleteNodeInMiddle rm = new DeleteNodeInMiddle();
        rm.display(n);
        System.out.println();
        System.out.println("after deletion: ");
        rm.deleteMiddle(mid);
        rm.display(n);
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
