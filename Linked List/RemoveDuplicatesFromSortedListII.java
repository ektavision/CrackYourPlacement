
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
          if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode pre = dummy, cur = head;
        
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        
        return dummy.next;
    }
}