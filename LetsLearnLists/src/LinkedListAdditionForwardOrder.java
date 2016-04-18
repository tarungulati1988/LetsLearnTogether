/**
 * Created by tgulati on 4/17/16.
 */

/**
 * Two numbers represented by a linked list­where each node contains sin­gle digit.
 * The digits are stored in Forward order, means head is pointing to the last digit of the number.
 *
 * First Number : 1007
 * Second Number : 93
 * Addition : 1100
 * 
 */
public class LinkedListAdditionForwardOrder {

    public void display(Node head) {
        Node currNode = head;
        while (currNode != null) {
            System.out.print("->" + currNode.data);
            currNode = currNode.next;
        }
    }

    public static void main(String args[]) {
        LinkedListAdditionForwardOrder l = new LinkedListAdditionForwardOrder();
        Node h1 = new Node(1);
        h1.next = new Node(0);
        h1.next.next = new Node(0);
        h1.next.next.next = new Node(7);
        System.out.print("First Number : ");
        l.display(h1);
        Node h2 = new Node(9);
        h2.next = new Node(3);
        System.out.print("\n Second Number : ");
        l.display(h2);
        l.add(h1, h2);
    }

    public int getLength(Node head){
        int len=0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }

    private void add(Node h1, Node h2) {

        if (h1 == null & h2 == null)
            return;
        // calculate length of both the lists
        int length1 = getLength(h1);
        int length2 = getLength(h2);
        System.out.println("l1: " + length1);
        System.out.println("l2: " + length2);

        if (length1 > length2) {
            int diff = length1 - length2;
            while (diff > 0) {
                Node n = new Node(0);
                n.next = h2;
                h2 = n;
                diff--;
            }
        }

        if (length2 > length1) {
            int diff = length2 - length1;
            while (diff > 0) {
                Node n = new Node(0);
                n.next = h1;
                h1 = n;
                diff--;
            }

        }

        int carry = 0;
        int sum = 0;
        int l = Math.max(length1, length2);
        while (l > 0) {
            int total = h1.data + h2.data + carry;
            sum = sum * 10;
            carry = 0;
            if (total > 10) {
                carry = 1;
                total = total - 10;
            }
            sum = sum + total;
            System.out.println(sum);
            h1 = h1.next;
            h2 = h2.next;
            l--;
        }
        System.out.println("sum: " + sum);
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