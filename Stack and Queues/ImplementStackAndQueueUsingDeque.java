import java.lang.*;

class Solution {
    static class DQueNode {
        int value;
        DQueNode next;
        DQueNode prev;
    }
    static class deque {

        private DQueNode head;
        private DQueNode tail;
        public deque() { head = tail = null; }
        boolean isEmpty()
        {
            if (head == null)
                return true;

            return false;
        }
        int size()
        {
            if (!isEmpty()) {
                DQueNode temp = head;
                int len = 0;

                while (temp != null) {
                    len++;
                    temp = temp.next;
                }
                return len;
            }
            return 0;
        }
        void insert_first(int element)
        {
            DQueNode temp = new DQueNode();
            temp.value = element;
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            }
            else {
                head.prev = temp;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }
        }
        void insert_last(int element)
        {
            DQueNode temp = new DQueNode();
            temp.value = element;
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            }
            else {
                tail.next = temp;
                temp.next = null;
                temp.prev = tail;
                tail = temp;
            }
        }
    public void remove_first()
    {
    if (!isEmpty()) {
        if (head == tail) {
            head = tail = null;
            return;
        } else {
            head = head.next;
            head.prev = null;
        }
    } else {
        System.out.println("List is Empty");
        }
    }
        void remove_last()
        {
            if (!isEmpty()) {
                DQueNode temp = tail;
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
                return;
            }
            System.out.print("List is Empty");
        }
        void display()
        {
            if (!isEmpty()) {
                DQueNode temp = head;

                while (temp != null) {
                    System.out.print(temp.value + " ");
                    temp = temp.next;
                }

                return;
            }
            System.out.print("List is Empty");
        }
    }
    static class Stack {
        deque d = new deque();
        public void push(int element)
        {
            d.insert_last(element);
        }
        public int size() { return d.size(); }
        public void pop() { d.remove_last(); }
        public void display() { d.display(); }
    }
    static class Queue {
        deque d = new deque();
        public void enqueue(int element)
        {
            d.insert_last(element);
        }
        public void dequeue() { d.remove_first(); }
        public void display() { d.display(); }
        public int size() { return d.size(); }
    }
    public static void main(String[] args)
    {
        Stack stk = new Stack();
        stk.push(7);
        stk.push(8);
        System.out.print("Stack: ");
        stk.display();
        System.out.println();
        stk.pop();
        System.out.print("Stack: ");
        stk.display();
        System.out.println();
        Queue que = new Queue();

        que.enqueue(12);
        que.enqueue(13);
        System.out.print("Queue: ");
        que.display();

        System.out.println();

        que.dequeue();
        System.out.print("Queue: ");
        que.display();

        System.out.println();
        System.out.println("Size of stack is "
                           + stk.size());
        System.out.println("Size of queue is "
                           + que.size());
    }
}
