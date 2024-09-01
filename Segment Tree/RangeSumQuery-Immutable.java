class NumArray {
    int[] nums;
  public NumArray(int[] nums) {
       int s = 0;
      for(int i=0;i<nums.length;i++)
      {
          nums[i] += s;
          s = nums[i];
      }
      this.nums = nums;
  }
  
  public int sumRange(int left, int right) {
        if(left==0) { return nums[right];}
      else { return nums[right]-nums[left-1];}
  }
}
