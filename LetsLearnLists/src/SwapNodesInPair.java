/**
 * Created by tgulati on 4/17/16.
 */
public class SwapNodesInPair {

    public static Node swapNodeIterative(Node head) {
        Node ptr1Prev = null;
        Node baseHead = null;

        while (head != null && head.next != null) {
            //Take 2 pointers, one on head
            Node ptr1 = head;
            //another on head.next
            Node ptr2 = head.next;
            //store the reference of next node of pointer2
            Node ptr2Next = head.next.next;
            // make the pointer1 points to pointer2 next
            ptr1.next = ptr2Next;

            if (ptr1Prev != null) {
                // link the next pair swap to the previous one
                ptr1Prev.next = ptr2;
            } else {
                // pointer 2 will become the new head after the first swap
                baseHead = ptr2;
            }
            //reverse the next link of pointer 1
            ptr2.next = head;
            //move 2 modes forward for next pairwise swap
            ptr1Prev = ptr1;
            head = ptr2Next;

        }
        return baseHead;
    }

    public static Node swapNodeRecursive(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node ptr1 = head;
        Node ptr2 = head.next;
        Node ptr2Next = head.next.next;
        ptr2.next = head;
        Node newhead = ptr2;
        ptr1.next = swapNodeRecursive(ptr2Next);
        return newhead;
    }

    public static void display(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        display(head);
        System.out.println();
        Node node = swapNodeIterative(head);
        System.out.println("Swapping Nodes using Iterative method");
        display(node);

        System.out.println();
        System.out.println("Swapping again using Recursive method");
        Node n = swapNodeRecursive(node);
        display(n);
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


