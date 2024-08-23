class Solution {
    public int climbStairs(int n) {
         int[] dp = new int[n + 1];
        return count(dp, n);
    }
     public int count(int[] dp, int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        
        if (dp[n] > 0) {
            return dp[n];
        }
        
        dp[n] = count(dp, n - 1) + count (dp, n - 2);
        return dp[n];
    }
}