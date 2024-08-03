import java.io.*;
class Node {
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
class GFG {
 
    Node left = null;
    void printlist(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " ");
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }
    void rearrange(Node head)
    {
        if (head != null) {
            left = head;
            reorderListUtil(left);
        }
    }
 
    void reorderListUtil(Node right)
    {
 
        if (right == null) {
            return;
        }
        reorderListUtil(right.next);
        if (left == null) {
            return;
        }
        if (left != right && left.next != right) {
            Node temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        }
        else { 
            if (left.next == right) {
                left.next.next = null; 
                left = null;
            }
            else {
                left.next = null; 
                left = null;
            }
        }
    }
    public static void main(String[] args)
    {
 
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
       
        GFG gfg = new GFG();
        gfg.printlist(head);        
 
        gfg.rearrange(head);
 
        gfg.printlist(head);
    }
}