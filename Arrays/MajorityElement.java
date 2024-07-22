class Solution {
    public int majorityElement(int[] nums) {
        
         int n=nums.length;
         int major = nums[0];
        int count = 1;
        for(int i = 1; i < n; i++){
            if(count == 0){
                count = 1;
                major = nums[i];
                continue;
            }
            if(nums[i] == major)
                count++;
            else
                count--;
        }
        return major;
    }
}