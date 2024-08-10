
class Solution {
    int[] pre_arr;
   int[] post_arr;
   Map<Integer, Integer> map = new HashMap<>();
   int index = 0;
   public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        pre_arr = preorder;
       post_arr = postorder;
       for(int i = 0; i < postorder.length; i++){
           map.put(postorder[i], i);
       }
       return dfs(preorder.length);
       
   }
    private TreeNode dfs(int preIdx){
       if(index >= pre_arr.length) return null;
       int curVal = pre_arr[index];
       int curIdx = map.get(curVal);
       if(preIdx < curIdx) return null;
       index++;
       TreeNode root = new TreeNode(curVal);
       root.left = dfs(curIdx);
       root.right = dfs(curIdx);
       return root;
   }
}