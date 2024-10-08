
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
         int count =0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        
        ListNode temp = dummy;
        
        while(temp.next!=null){
            temp = temp.next;
            count++;
        }
        temp = dummy;
        while(temp.next!=null){
            if(count<k) break;
            int nodes = k-1;
            ListNode tempnext = temp.next;
            ListNode first = temp.next;
            ListNode second = first.next;
            
            while(nodes-- > 0){
                ListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }
            count-=k;
            temp.next = first;
            tempnext.next = second;
            temp = tempnext;
            
        }
        return dummy.next;
    }
}