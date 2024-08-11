
class Solution {
    static int count;
    static int res;
    public int kthSmallest(TreeNode root, int k) {
          count = k;
        kthSmallestUtil(root);
        return res;
    }
      public void kthSmallestUtil(TreeNode root) {
        if (root == null)
            return;
        
        kthSmallestUtil(root.left);
        
        count -= 1;
        
        if (count == 0) {
            res = root.val;
            return;
        }
        
        kthSmallestUtil(root.right);
        
        return;
    }
}