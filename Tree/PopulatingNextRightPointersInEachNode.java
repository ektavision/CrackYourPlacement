
class Solution {
    public Node connect(Node root) {
          if(root == null) return root;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            Node pre = new Node();
            for(int i = 0; i < size; i++){
                Node top = q.poll();
                pre.next = top;
                pre = top;
                if(top.left != null){
                    q.add(top.left);
                }
                if(top.right != null){
                    q.add(top.right);
                }
            }
        }
        return root;
    }
}