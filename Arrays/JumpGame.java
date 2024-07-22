class Solution {
    public boolean canJump(int[] nums) {
       int maxDistance =nums[0];
       for(int i=0; i<nums.length; i++){
        if(i==nums.length -1){
            return true;
        }
        if(maxDistance==0 && nums[i]==0){
            return false;
        }
        if(nums[i]> maxDistance){
            maxDistance=nums[i];

        }
        maxDistance--;
       }
       return false; 
    }
}