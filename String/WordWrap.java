
class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
            int n = nums.length;
            int dp[][] = new int[n+1][k+1];
            
            for (int i=0;i<=n;i++){
                for (int j=0;j<=k;j++){
                    dp[i][j] = -1;
                }
            }
            
            int ans = Helper(0,k,nums,k,dp);
            return ans;
    }
           public int Helper(int idx, int rem, int[] arr, int k, int dp[][]){
            
            if (idx==arr.length) return 0;
            if (dp[idx][rem] != -1) return dp[idx][rem];
            
            int includeInSameLine = Integer.MAX_VALUE;
            
            if (arr[idx] < rem){
                includeInSameLine = Helper(idx+1, rem-arr[idx]-1, arr,k,dp);
            }
            
            else if (arr[idx] == rem){
                includeInSameLine = Helper(idx+1,k,arr,k,dp);
            }
            
            int includeInNextLine = ((rem+1)*(rem+1)) + Helper(idx+1, k-arr[idx]-1,arr,k,dp);
            
            return dp[idx][rem] = Math.min(includeInSameLine, includeInNextLine);
        }
}