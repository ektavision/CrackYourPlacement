
class Solution {
    public List<TreeNode> generateTrees(int n) {
         ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(n==0){
            result.add(null);
            return result;
        }
        return generateTree(1,n); 
    }
      private ArrayList<TreeNode> generateTree(int start, int end){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(start>end) {
            res.add(null);
            return res;
        }
        for(int i=start; i<=end; i++){
            ArrayList<TreeNode> left=generateTree(start, i-1);
	        ArrayList<TreeNode> right=generateTree(i+1, end);
	        
	        for(int j=0;j<left.size(); j++){
	            for(int k=0;k<right.size();k++){
	                TreeNode root=new TreeNode(i);
	                root.left=left.get(j);
	                root.right=right.get(k);
	                res.add(root);
	            }
	        }
        }
        return res;
    }
}