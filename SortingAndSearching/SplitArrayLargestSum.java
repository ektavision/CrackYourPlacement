class Solution {
    public int splitArray(int[] nums, int k) {
          int maxNo = 0;
        long total = 0;

        for (int el : nums) {
            maxNo = Math.max(el, maxNo);
            total += el;
        }


        long low = maxNo;
        long high = total;
        while (low< high) {
            long mid = (low) + (high-low)/2;
            if (validDivisionPossible(mid, nums, k)) {

                high = mid ;
            } else {
                low = mid + 1;
            }
        }
        return (int)low;
    }
     public boolean validDivisionPossible(long maxPossibleSum, int[] nums, int k) {
        int totalSubsetCount = 1;
        long totalRunningSum = 0;
        for(int num : nums) {
            totalRunningSum += num;
            if (totalRunningSum > maxPossibleSum) {
                totalRunningSum = 0;
                totalRunningSum += num;

                totalSubsetCount++;

                if (totalSubsetCount > k) {
                    return false;
                }
            }
        }
        return true;
        }
}