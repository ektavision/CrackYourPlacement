
class Tree
{
    public static float findMedian(Node root)
    {
        // code here.
         List<Integer> temp = helper(root, new ArrayList<Integer>());
        if(temp.size()%2 == 0){
            return (temp.get((temp.size()/2)-1) + temp.get((temp.size()/2)))/2.0f;
        }
        return temp.get(temp.size()/2);
        
    }
     public static List<Integer> helper(Node root, List<Integer> temp){
        if(root != null){
            temp = helper(root.left, temp);
            temp.add(root.data);
            temp = helper(root.right, temp);
            return temp;
        }
        return temp;
    }
}