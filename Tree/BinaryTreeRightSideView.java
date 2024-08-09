
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> thisLevel = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                thisLevel.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                
            }
            answer.add(thisLevel.get(thisLevel.size() - 1));
        }
        return answer;
    }
}