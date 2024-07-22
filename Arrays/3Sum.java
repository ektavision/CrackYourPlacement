class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>(); 
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            if (0 < i && nums[i] == nums[i-1]) continue;
            int left = i+1, right = n-1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    right--;
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[left+1]) left++;
                    left++;
                } else {
                    while (left < right && nums[right] == nums[right-1]) right--;
                    right--;
                }
            }
        }
        return res; 
    }
}