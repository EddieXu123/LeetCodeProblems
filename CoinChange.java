class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] output = new int[amount + 1]; // output[amount] will give the fewest number of coins needed to make up 'amount'
        
        for (int i = 1; i <= amount; i++) { // Start with 1 because dp[0] = 0
            output[i] = amount + 1; // We don't even know if we can make any of these amounts to begin with, so let's do a maximum number
        }
    
        for (int i = 0; i < coins.length; i++) { // We want to simulate taking all these coins (For every single cent)
            for (int j = 0; j <= amount; j++) { // We need to go all the way up to amount
                if (coins[i] <= j) { // If the coin is less than the amount
                    output[j] = Math.min(output[j], output[j - coins[i]] + 1); // Let's take that coin because we can. 
                }
            }
        }
        
        return output[amount] > amount ? -1 : output[amount]; // If our dp[amount] is greater than amount, then we never found a good combination of coins
    }
}
