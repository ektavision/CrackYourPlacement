
class Solution {
    TreeNode prev = null, first = null, middle = null, last = null;


 public void recoverTree(TreeNode root) {
      findFaultNodes(root);
     
     int temp;
     
     if (first != null && last != null) {
         temp = first.val;
         first.val = last.val;
         last.val = temp;
     }
     else if (first != null && middle != null) {
         temp = middle.val;
         middle.val = first.val;
         first.val = temp;
     }
 }
  public void findFaultNodes(TreeNode root) {
     
     if (root == null)
         return;
     
     findFaultNodes(root.left);
     
     if (prev == null) {
         prev = root;
     }
     
     else {
         if (root.val < prev.val) {
             if (first == null) {
                 first = prev;
                 middle = root;
             }
             else {
                 last = root;
             }
         }
     
         prev = root;
     }
     
     findFaultNodes(root.right);
     
 }

}