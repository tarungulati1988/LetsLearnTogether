/**
 * Created by tgulati on 4/17/16.
 */
public class LinkedListAdditionReverseOrder {
    public Node add(Node node1, Node node2) {

        int carry = 0;
        Node temp = null;
        Node curr = null;

        // iterate over, add, carry the carry forward and keep inserting into the new list
        while (node1 != null && node2 != null) {
            int a = node1.data;
            int b = node2.data;
            int total = a + b + carry;

            if (total >= 10) {
                carry = 1;
                total = total - 10;
            }

            // add the total minus the carry into the new node in the result list
            if (temp == null) {
                temp = new Node(total);
                curr = temp;
            } else {
                Node node = new Node(total);
                curr.next = node;
                curr = curr.next;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        // now if one of the lists is bigger than the other
        while (node1 != null) {
            int x = node1.data + carry;
            carry = 0;
            Node tempNode1 = new Node(x);
            curr.next = tempNode1;
            curr = curr.next;
            node1 = node1.next;
        }

        while (node2 != null) {
            int x = node2.data + carry;
            carry = 0;
            Node tempNode2 = new Node(x);
            curr.next = tempNode2;
            curr = curr.next;
            node2 = node2.next;
        }

        // if still carry is left after both the lists were of the same size, add carry into the new next node
        if (carry > 0) {
            Node tempCarry = new Node(1);
            curr.next = tempCarry;
            curr = curr.next;
        }
        return temp;
    }

    public void display(Node head) {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(" " + currNode.data);
            currNode = currNode.next;
        }
        System.out.println();
    }

    public void displayReverse(Node head) {
        if (head == null) {
            return;
        }
        display(head.next);
        System.out.print(head.data);
    }

    public static void main(String args[]) {
        LinkedListAdditionReverseOrder obj = new LinkedListAdditionReverseOrder();
        Node h1 = new Node(5);
        h1.next = new Node(9);
        h1.next.next = new Node(5);
        h1.next.next.next = new Node(7);
        System.out.println("Num1:");
        obj.display(h1);

        Node h2 = new Node(5);
        h2.next = new Node(9);
        System.out.println("Num2: ");
        obj.display(h2);
        Node x = obj.add(h2, h1);

        System.out.println("In reverse: ");
        obj.display(x);
        System.out.println("Sum of num1 + num2 = ");
        obj.displayReverse(x);
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
