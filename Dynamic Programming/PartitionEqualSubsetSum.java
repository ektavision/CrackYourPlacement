
class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
            int sum = 0;
        for(int i=0;i<N;i++){
            sum = sum + arr[i];
        }
        if(sum % 2 != 0){
            return 0;
        }
        sum = sum /2;
        boolean ans = subset(arr, sum, N);
        if(ans != true){
            return 0; 
        }
        return 1;
    }
    static boolean subset(int arr[], int sum, int n){
        boolean dp[][] = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v = arr[i-1];
                if(v <= j && dp[i-1][j-v] == true){
                    dp[i][j] = true;
                }
                else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][sum];
    }
}