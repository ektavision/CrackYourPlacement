public class Sort012 {
    public static Node createList(Node head, int val) {
        Node head0 = new Node(-1);
        Node curr = head0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                curr.next = new Node(val);
                curr = curr.next;
            }
            temp = temp.next;
        }

        head0 = head0.next;
        return head0;
    }

    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node head0 = createList(head, 0);
        Node head1 = createList(head, 1);
        Node head2 = createList(head, 2);

        Node temp = head0;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head1;

        temp = head1;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head2;

        return head0;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(1);
        ll.insertAtHead(0);
        ll.insertAtHead(2);
        ll.insertAtHead(0);
        ll.insertAtHead(2);
        ll.insertAtHead(1);
        ll.insertAtHead(1);
        ll.printLL();
        ll.printLL(sort(ll.head));
    }
}