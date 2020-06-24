class UniqueBinaryTrees {
    public int numTrees(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        
        return dp[n];
    }
}


/* Catalan Formula recursively
    public int numTrees(int n) {
        int answer = 0;
        if (n <= 1) return 1;
        
        for (int i = 0; i < n; i++) {
            answer += numTrees(i) * numTrees(n - i - 1);
        }
        
        return answer;
    }
*/
