public class CoinChange {
  
  public static int coinChange(int[] arr, int sum) {
    int[] output = new int[sum + 1];
    
    for (int i = 1; i <= sum; i++) {
      output[i] = sum + 1;
    }
    
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j <= sum; j++) {
        if (arr[i] <= j) {
          output[j] = Math.min(output[j], output[j - arr[i]] + 1);
        }
      }
    }
    
    return output[sum] > sum ? -1 : output[sum];
  }
  
}
  
