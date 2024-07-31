public class Solution {
    public boolean hasCycle(ListNode head) {
         if (head == null || head.next == null)
            return false;
        
        ListNode curr_node = head;
        ListNode next_node = head;

        while (next_node != null && next_node.next != null) {
            curr_node = curr_node.next;
            next_node = next_node.next.next;
            if (curr_node == next_node)
                return true;
        }

        return false;
    }
}