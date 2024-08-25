
class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
    char[] m = str1.toCharArray();
    char[] n = str2.toCharArray();

    int[][] dp = new int[m.length + 1][n.length + 1];

    int max = 0;

    for (int i = 1; i <= m.length; i++)
      for (int j = 1; j <= n.length; j++)

        if (m[i - 1] == n[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;

          max = Math.max(dp[i][j], max);
        }

    return max;
    }
}