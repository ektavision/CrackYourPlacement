class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> lst=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        subset(0,lst,list,nums);
        return lst; 
    }
     public void subset(int index,List<List<Integer>> lst,List<Integer> list,int[] nums)
    {
        List<Integer> listt=new ArrayList(list);
        lst.add(listt);
        for(int i=index;i<nums.length;i++)
        {
            list.add(nums[i]);
            subset(i+1,lst,list,nums);
            list.remove(list.size()-1);
        }
    }
}