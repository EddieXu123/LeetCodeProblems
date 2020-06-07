class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1]; // dp[i][j] represents the number of cominbations to make amount 'j' using the first 'i' coins.
        
        for (int i = 0; i <= coins.length; i++) { 
            dp[i][0] = 1; // If the amount you want is 0, then there is only 1 way of making 0 amount (the True in subset sum)
        }
        
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 0; // Otherwise, I have zero coins and an amount that's not 0
        }
        
        for (int i = 1; i <= coins.length; i++) { // Going through my coins
            for (int j = 1; j <= amount; j++) { // With my j representing the amount I'm at
                if (j >= coins[i - 1]) { // If the amount I am at is greater than the coin I am at (meaning there is a coin that can be used in forming my total amount)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]]; // I add the number of ways to form the amount using the first i-1 coins, to the amount of ways to form the amount using the i-th coin. (I then need to subtract the i-th coin from the total amount)
                }
                else { // If the coin denomination I am at is greater than the amount I am at
                    dp[i][j] = dp[i - 1][j]; // We can ignore the i-th coin and still the number of ways to form the j amount is with the i-1 coins.
                }
            }
        }
        
        return dp[coins.length][amount];
    }
}
