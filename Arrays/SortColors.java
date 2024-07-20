class Solution {
    public void sortColors(int[] nums) {
         int start = 0;
        int end = nums.length - 1;
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
            {
                arr[start] = 0;
                start++;
            }
            else if(nums[i] == 2)
            {
                arr[end] = 2;
                end--;
            }
        }
        for(int i = start; i <= end; i++)
        {
            arr[i] = 1;
        }
        for(int i = 0; i < nums.length; i++)
        {
            nums[i] = arr[i];
        }
    }
}