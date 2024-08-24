class Solution {
    public int coinChange(int[] coins, int amount) {
          int n = coins.length;
        int a, c;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int coin : coins)
        {
            for (a = coin; a <= amount; ++a)
            {
                dp[a] = Math.min(dp[a],dp[a-coin]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}