/*
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.
 * 
 * Find all elements that appear twice in the array without extra space in O(n) runtime
 * 
 * @Inspired by Nick White
 * Comments by Eddie Xu ;)
 */


/*
 * Basic Idea: We want to keep track of numbers we have already encountered by marking their positions. In this case, we make their positions negative
 * This only works if the elements in the array are between 1 and the size of the array (Otherwise there will be IndexOutOfBounds
 */
import java.util.LinkedList;
import java.util.List;

public class CleverFindingDuplicates {   
  public static List<Integer> findDuplicates(int[] nums) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
    	// If the element at the nums[i] position is already marked (is negative)
      if (nums[Math.abs(nums[i]) - 1] < 0) {
    	  // The nums[i] must have been a duplicate
        list.add(Math.abs(nums[i]));
      }
      // Otherwise mark the element at the nums[i] position
      nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
    }
    return list; 
  }
  
  public static void main(String[] args) {
    int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
    System.out.println(findDuplicates(arr));
  }
}


