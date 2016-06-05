/**
 * Created by tgulati on 6/5/16.
 */
public class RotateList {
    
    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);

        display(head);
        head = rotate(head, 4);
        display(head);
    }

    private static Node rotate(Node head, int k) {
        if(head == null)
            return null;

        // rotate 0 to k
        // rotate k+1 to n
        // rotate complete list
        int n = 0;
        Node l1 = head;
        Node l2 = head;
        Node temp = head;
        while(temp!=null) {
            temp = temp.next;
            n++;
        }
        int j = 0;
        while(j < k) {
            j++;
            l2 = l2.next;
        }
        int i = 0;
        Node curr = l1;
        Node prev = null;
        Node next = null;
        while(i < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            //head = head.next;
            i++;
        }

        head = prev;
        display(head);
        curr = l2;
        prev = null;
        next = null;

        while(k <= n && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            //head = head.next;
            n--;
        }
        l2 = prev;
        display(l2);

        Node fakehead = new Node(0);
        Node p1 = fakehead;
        while(head!= null) {
            p1.next = head;
            head = head.next;
            p1 = p1.next;
        }
        display(p1);
        p1.next = l2;
        display(fakehead.next);

        curr = fakehead.next;
        next = null;
        prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public static void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println("-----------");
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
