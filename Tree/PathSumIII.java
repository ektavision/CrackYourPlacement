
class Solution {
    private int pathSum_a(TreeNode root, int sum){
       if(root == null) return 0;
       int res = 0;
       if(root.val == sum) res++;
       res += pathSum_a(root.left, sum-root.val);
       res += pathSum_a(root.right, sum-root.val);
       return res;
   }
   public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
       return pathSum(root.left, targetSum) + pathSum_a(root, targetSum) + pathSum(root.right, targetSum);
   }
}