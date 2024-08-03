
class Solution {
    Node divide(Node head) {
        // code here
           if(head==null || head.next==null)
        return head;
        
        Node temp=head;
        Node prev=null;
        Node mid=null;
        if(temp.data%2==0)
        {
            temp=temp.next;
            prev=head;
            mid=head;
        }
        while(temp!=null)
        {
            if(temp.data%2==0)
            {
                if(mid==null)
                {
                    prev.next=temp.next;
                    temp.next=head;
                    head=temp;
                    mid=head;
                    temp=prev.next;
                }
                
                else if(mid.next==temp)
                {
                    mid=temp;
                    prev=temp;
                    temp=temp.next;
                }
             
                else
                {
                    prev.next=temp.next;
                    temp.next=mid.next;
                    mid.next=temp;
                    mid=temp;
                    temp=prev.next;
                }
            }
            else
            {
                prev=temp;
                temp=temp.next;
            }
        }
        return head;
        
    }
}