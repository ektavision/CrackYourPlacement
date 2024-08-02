
class Solution {
    public ListNode reverseList(ListNode head) {
         if(head == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}