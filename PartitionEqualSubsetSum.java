import java.util.*;

public class PartitionEqualSubsetSum {
  public static boolean canPartition(int[] arr) {
    int total = 0;
    for (int i : arr) {
      total += i;
    }
    
    // If the total is odd, then there can't be two equal subsets
    if (total % 2 != 0) {
      return false;
    }
    // Return helper method with index and sum included
    return canPartition(arr, 0, 0, total);
  }
  
  // Helper method with index and sum like in subset sum
  public static boolean canPartition(int[] arr, int index, int sum, int target) {
    // If the sum of one half of my array equals half the target, it's true
    if (target / 2 == sum) {
      return true;
    }
    
    // If the sum is greater than half or if my index is outside my array, it's false
    if (sum > target / 2 || index >= arr.length) {
      return false;
    }
    
    // Subset sum idea: either the index+1 is added to the sum or not
    return canPartition(arr, index + 1, sum, target) || 
      canPartition(arr, index + 1, sum + arr[index], target);
    
  }
  
  
  public static boolean dpCanPart(int[] arr) {
    int total = 0;
    for (int i : arr) {
      total += i;
    }
    
    // If the total is odd, then there can't be two equal subsets
    if (total % 2 != 0) {
      return false;
    }
    // Return helper method with index and sum included
    return dpCanPartition(arr, 0, 0, total, new HashMap<String, Boolean>());
  }
  
  public static boolean dpCanPartition(int[] arr, int index, int sum, int target, HashMap<String, Boolean> map) {
    String current = sum + "" + target;
    if (map.containsKey(current)) {
      return map.get(current);
    }
    
    if (target / 2 == sum) {
      return true;
    }
    
    // If the sum is greater than half or if my index is outside my array, it's false
    if (sum > target / 2 || index >= arr.length) {
      return false;
    }
    
    boolean foundPart = dpCanPartition(arr, index + 1, sum, target, map) || 
      dpCanPartition(arr, index + 1, sum + arr[index], target, map);
    map.put(current, foundPart);
    return foundPart;
    
  }
  
  
  
  
  public boolean leetCodeCanPart(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }
    
    int total = 0;
    for (int i : nums) {
      total += i;
    }
    if (total % 2 != 0) {
      return false;
    }
    
    total /= 2;
    
    boolean[] dp = new boolean[total + 1];
    dp[0] = true;
    
    for (int i = 1; i <= nums.length; i++) {
      for (int j = total; j >= nums[i - 1]; j--) {
        dp[j] = dp[j] || dp[j - nums[i - 1]];
      }
    }
    return dp[total];
  }
  
  
  public static boolean bestMethod(int[] arr) {
    int total = 0;
    for (int i : arr) {
      total += i;
    }
    
    if (total % 2 != 0) {
      return false;
    }
    
    total /= 2;
    
    boolean[] dp = new boolean[total + 1];
    dp[0] = true;
    
    for (int num : arr) {
      for (int j = total; j >= 0; j--) {
        if (j >= num) // If the total is greater than the current element in my array
          dp[j] = dp[j] || dp[j - num]; // Then I have room to take away the value
      }
    }
    
    return dp[total];  
  }
  
  
  public static void main(String[] args) {
    int[] arr = {1, 5, 5, 11};
    System.out.println(dpCanPart(arr));
    
    
  }
}
