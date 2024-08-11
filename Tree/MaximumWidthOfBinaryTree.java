
class Node{
    TreeNode node ;
    int level;
    Node(TreeNode node , int level){  
        this.node=node;
        this.level=level;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
         Deque<Node> q = new LinkedList<>();

        q.add(new Node(root,0));
        int maxWidth = 0;
        
        while(!q.isEmpty()){
            int n = q.size();
            
            int width = q.getLast().level-q.getFirst().level+1;
            maxWidth = Math.max(maxWidth,width);
            
            for(int i=0 ; i<n ; i++){
                Node p = q.poll();

                if(p.node.left!=null){
                    q.addLast(new Node(p.node.left , 2*p.level));
                }
                if(p.node.right!=null){
                    q.addLast(new Node(p.node.right, 2*p.level+1));
                }
            }
        }

        return maxWidth;
    }
}