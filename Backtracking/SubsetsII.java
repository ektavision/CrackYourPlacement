class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums, 0, subset, subsets);
        return subsets;
    }
      public void subsetsWithDup(int[] nums, int start, List<Integer> subset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(subset));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            subsetsWithDup(nums, i + 1, subset, subsets);
            subset.remove(subset.size() - 1);
        }
}}