class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]]; 
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int finder = 0;
        while (slow != finder) {
            slow = nums[slow];
            finder = nums[finder];
        }
        return slow;  
    }
}