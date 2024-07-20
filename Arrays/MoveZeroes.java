class Solution {
    public void moveZeroes(int[] nums) {
          int ap = 0;
        int ep = 0;
        int n = nums.length;
        
        while(ep < n){
            if(nums[ap] != 0){
                ap++;
                ep = ap;
            }else if(nums[ep] == 0){
                ep++;
            }else{
                int temp = nums[ap];
                nums[ap] = nums[ep];
                nums[ep] = temp;
            }
        }
    }
}