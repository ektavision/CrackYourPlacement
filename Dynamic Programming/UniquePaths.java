class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[2][n];
        int row, col, index = 0;
        for (col = 0; col < n; ++col)
            ways[0][col] = 1;
        for (row = 1; row < m; ++row)
        {
            ways[1-index][0] = 1;
            for (col = 1; col < n; ++col)
                ways[1-index][col] = ways[index][col]+ways[1-index][col-1];
            index = 1-index;
        }
        return ways[index][n-1];  
    }
}