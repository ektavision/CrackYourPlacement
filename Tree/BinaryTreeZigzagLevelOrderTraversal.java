
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if (root == null) return res;
        
        deque.add(root);
        while ( !deque.isEmpty() ) {
            List<Integer> current = new LinkedList<>();
            int m = deque.size();
            
            for (int i = 0; i < m; i++) {
                TreeNode node = deque.removeFirst();
                
                if ( res.size() % 2 == 0) {
                    current.add(node.val);
                } else {
                    current.add(0, node.val);
                }
                
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
    
            res.add(current);
        }
        
        return res; 
    }
}