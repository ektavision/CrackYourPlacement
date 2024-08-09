
class BSTIterator {
    Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
               this.stack = new Stack<TreeNode>();
                addLeftmost(root);
        }
          public void addLeftmost(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        public int next() {
             TreeNode top = stack.pop();
            if (top.right != null) {
               
                addLeftmost(top.right);
            }
            return top.val;
        }
        
        public boolean hasNext() {
              return stack.size() > 0;
        }
    }
    