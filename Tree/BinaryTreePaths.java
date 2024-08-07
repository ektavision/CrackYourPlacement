
class Solution {
    private List<String> ans = new ArrayList<>();
   private List<String> t = new ArrayList<>();
   public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
       return ans;
   }
    private void dfs(TreeNode root) {
       if (root == null) {
           return;
       }
       t.add(root.val + "");
       if (root.left == null && root.right == null) {
           ans.add(String.join("->", t));
       } else {
           dfs(root.left);
           dfs(root.right);
       }
       t.remove(t.size() - 1);
   }
}