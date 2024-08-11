
class Solution
{
    int getCount(Node root,int l, int h)
    {
        //Your code here
          ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        int count=0;
        for(int i=0;i<arr.size();i++){
            if(l<=arr.get(i) && arr.get(i)<=h) count++;
        }
        return count;
    }
     void inorder(Node root,ArrayList<Integer> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
}
