class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] counts = new int[k];
        int sum = 0;
        for(int x: nums){
            sum += (x%k + k)%k;
            counts[sum % k]++;
        }
        int result = counts[0];
        for(int c : counts)
            result += (c*(c-1))/2;
        return result;

    }
}