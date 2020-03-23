/*
 * Adding 1 to an array of integers in linear time
 */

import java.util.Arrays;

public class AddOneToArray {
  public static int[] addToArray(int[] s) {
	  // Starting from the last index
    for (int i = s.length - 1; i >= 0; i--) {
    	// The first index of the array (moving from right to left)
    	// that is not a 9 will be incremented and immediately breaks the loop
    	// This will also solve the case where the i+1 index is a 9 and we need to increment the i-th index
      if (s[i] < 9) {
        s[i]++;
        return s;
      }
      // Otherwise, the value is a nine and we want to increment that 9
      s[i] = 0;
    }
    
    // Case where the array consists of only 9s
    int[] newAns = new int[s.length + 1];
    newAns[0] = 1;

    return newAns;
  }
  
  public static void main(String[] args) {
    int[] a = {9, 9, 9};
    AddOneToArray.addToArray(a);
    System.out.println(Arrays.toString(a));
    
  }
}
