
class Solution
{
    Node compute(Node head)
    {
        // your code here
          if(head.next==null){
            return head;
    }
    
        Node connect=compute(head.next);
        
        if(head.data>=connect.data){
            head.next=connect;
            return head;
        }
        
        return connect;
}
}