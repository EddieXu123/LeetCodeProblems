/*
 * Quick implementation of max subarray sum
 */

public class Kadane {
  
  public static int kadane(int[] arr) {
    // Set a current and max pointer to the beginning of the array which will be updated
    int current = arr[0];
    int max = current;
    // Accessing the rest of the elements of the array in linear time
    for (int i = 1; i < arr.length; i++) {
      // current sum becomes either the next element (In the case current < 0 and next > 0), or the current element plus the next element
      // This will also check for negative numbers that do not outweigh neighboring positive numbers
      current = Math.max(arr[i], current + arr[i]);
      // max sum becomes either the updated current, or remains the same max
      max = Math.max(current, max);
    }
    return max;
  }
  
  public static void main(String[] args) {
    int arr[] = {1, 5, -3, -2, 6, -3, 5};
    System.out.println(kadane(arr)); // returns 9
  }
}
