public class SubsetSum {
  
  // Naive approach taking 2^n time because it calculates the same thing a bunch of times
  public static boolean subsetRecursive(int[] arr, int n, int target) { // n = length of array
    // If our list is empty and we have not reached our target, it is impossible
    if (n == 0 && target != 0) {
      return false;
    }
    
    // If our target is zero, we have successfully gotten a sum to equal target (or no numbers were required)
    if (target == 0) {
      return true;
    }
    
    // If our element at the end of the list is greater than target
    if (arr[n - 1] > target) {
      // It is not included in our subset and we can do the same thing without it
      return subsetRecursive(arr, n - 1, target);
    }
    
    // Otherwise we can just return the function with or without the target - the last element
    return subsetRecursive(arr, n - 1, target) || subsetRecursive(arr, n - 1, target - arr[n - 1]);
  }
  
  
  // Dynamic Programming approach
  public static boolean subset(int[] arr, int target) {
    boolean dp[][] = new boolean[arr.length + 1][target + 1];
    
    // If the target == 0, that column is true
    for (int i = 0; i <= arr.length; i++) {
      dp[i][0] = true;
    }
    
    // If the target has value but the array is empty, that row is false
    for (int i = 1; i <= target; i++) {
      dp[0][i] = false;
    }
    
    // Going through the matrix
    for (int i = 1; i <= arr.length; i++) {
      for (int j = 1; j <= target; j++) {
        // If my element in my original list is greater than target
        if (arr[i - 1] > j) {
          // We can definitely exclude that number (it doesn't contribute to the set)
          dp[i][j] = dp[i - 1][j];
        }
        // Otherwise, we don't know if we can or cannot include it in the set
        else {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
        }
      }
    }
    return dp[arr.length][target];
  }
  
  
  public static void main(String[] args) {
    int[] arr = {1, 3, 5, 2};
    System.out.println(subsetRecursive(arr, arr.length, 13));
    System.out.println(subset(arr, 11));
  }
}

