
class Solution {

    public ListNode splitMidNode(ListNode head){
       ListNode slow = head, fast = head, pre = null;
       while(fast != null && fast.next != null){
           pre = slow;
           slow = slow.next;
           fast = fast.next.next;
       }
       pre.next = null;
       return slow;
   }
   public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;       
       ListNode l1 = head, l2 = splitMidNode(head);
       l1 = sortList(l1);
       l2 = sortList(l2);
       ListNode dummy = new ListNode(), res = dummy;
       
       while(l1 != null && l2 != null){
           if(l1.val < l2.val){
               res.next = l1;
               l1 = l1.next;
           }else{
               res.next = l2;
               l2 = l2.next;
           }
           res = res.next;
       }
       
       if(l2 != null) {
           res.next = l2;
       }else{
           res.next = l1;
       }
       return dummy.next;
   }
}