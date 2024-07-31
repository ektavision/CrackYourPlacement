class Solution {
    public ListNode deleteDuplicates(ListNode head) {
          ListNode prev = head;
    ListNode temp = prev.next;

    while (temp != null) {
      if (temp.val == prev.val) {
        temp = temp.next;
        continue;
      }

      prev.next = temp;
      prev = temp;
      temp = temp.next;
    }

    prev.next = null;
    return head;
    }
}