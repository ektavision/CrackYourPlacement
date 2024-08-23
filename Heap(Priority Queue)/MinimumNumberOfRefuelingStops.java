class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
         int n=stations.length;
        long[] dp = new long[n+1];
        dp[0]=startFuel;
        
        for(int i=0;i<n;i++){
            for(int refill = i;refill>=0 && dp[refill]>=stations[i][0];refill--){
                dp[refill+1] = Math.max(dp[refill+1],dp[refill] + stations[i][1]);
            }
        }
        
        for(int i=0;i<=n;i++){
            if(dp[i]>=target){
                return i;
            }
        }
        
        return -1;
    }
}