
class Solution {
    public void flatten(TreeNode root) {
           TreeNode traverse = root;
        while (traverse != null) {
            if (traverse.left != null) {
                TreeNode lefttree = traverse.left;
                while (lefttree.right != null) lefttree = lefttree.right;
                lefttree.right = traverse.right;
                traverse.right = traverse.left;
                traverse.left = null;
            }
            traverse = traverse.right;
        }
    }
}