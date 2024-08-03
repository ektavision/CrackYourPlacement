
class Solution {
    public ListNode partition(ListNode head, int x) {
         if(head == null || head.next == null) return head;
        
        ListNode dummyMin = new ListNode(), dummyMax = new ListNode();
        ListNode min = dummyMin, max = dummyMax;
        while(head != null){
            if(head.val < x){
                min.next = head;
                min = min.next;
            }else{
                max.next = head;
                max = max.next;
            }
            head = head.next;
        }
        min.next = dummyMax.next;
        max.next = null;
        return dummyMin.next; 
    }
}