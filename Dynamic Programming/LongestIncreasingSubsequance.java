class Solution {
    public int lengthOfLIS(int[] nums) {
        
    
    int[] T = new int[nums.length];

    for (int i = 1; i < nums.length; i++)

      for (int j = 0; j < i; j++)
        if (nums[i] > nums[j])
          if (T[j] + 1 > T[i])
            T[i] = T[j] + 1;

    int maxIndex = 0;
    for (int i = 0; i < T.length; i++)
      if (T[i] > T[maxIndex])
        maxIndex = i;

    return T[maxIndex] + 1;
    }
}