
class Solution
{
     Node head = null;
    Node prev = null;
    Node bToDLL(Node root)
    {
	//  Your code here
	 helper(root);
	    return head;
    }
      void helper(Node root){
        if(root == null) return;
        
        helper(root.left);
        if(head == null){
            head = root;
            prev = root;
        }else{
            prev.right = root;
            root.left = prev;
            prev = prev.right;
        }
        helper(root.right);
    }
}