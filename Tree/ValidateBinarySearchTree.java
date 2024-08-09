
class Solution {
    public boolean isValidBST(TreeNode root) {
          List<Integer> inOrderList = new LinkedList<>();

    helper(root, inOrderList);

    boolean isBST = true;
    int prev = inOrderList.get(0);
    for (int i = 1; i < inOrderList.size(); i++) {

      if (inOrderList.get(i) <= prev)
        isBST = false;

      prev = inOrderList.get(i);
    }

    return isBST;
    }
     void helper(TreeNode treeNode, List<Integer> inOrderList) {
    if (treeNode == null)
      return;

    helper(treeNode.left, inOrderList);
    inOrderList.add(treeNode.val);
    helper(treeNode.right, inOrderList);
  }

}