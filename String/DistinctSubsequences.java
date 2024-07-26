class Solution {
    public int numDistinct(String s, String t) {
         if (s.length() == 0 || t.length() == 0) {
        return 0;
    }
    int[][] T = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i < T.length; i++) {
        T[i][0] = 1;
    }
    for (int i = 1; i < T.length; i++) {
        for (int j = 1; j < T[0].length; j++) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                T[i][j] = T[i-1][j-1] + T[i - 1][j];
            } else {
                T[i][j] = T[i - 1][j];
            }
        }
    }
    return T[s.length()][t.length()];
    }
}