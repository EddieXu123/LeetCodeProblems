class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1 = text1.length();
        int t2 = text2.length();
        
        int[][] dp = new int[t1 + 1][t2 + 1];
        
        for (int i = 0; i < t1; i++) {
            for (int j = 0; j < t2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                }
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        
        return dp[t1][t2];
        
    }
}
