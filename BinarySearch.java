/*
 * Implementation of Binary Search
 * Returns the index of where an element is in a sorted array
 * If no such element exists, return -1;
 * 
 * Runtime: O(log(n))
 * 
 * Basic Idea: We only want to deal with half of the array because it is sorted. 
 */

public class Testing2 {
	public static int binarySearch(int[] array, int k) {
		int left = 0, right = array.length - 1;
		
		while (left <= right) {
			// We want to set a pointer to the middle of our range of possible values
			int middle = left + (right - left) / 2;
			
			// If the element in the middle of the array is our target value, we are done
			if (array[middle] == k) {
				return middle;
			}
			
			// Otherwise, if our element in the middle of the range is smaller than k, we only want to deal with the right half of what we already have
			if (array[middle] < k) {
				// We can shift our left pointer all the way to the middle + 1 because we know the middle is not a possible value
				left = middle + 1;
			}
		
			else {
				// Otherwise we can shift our right pointer all the way to the middle - 1 because we know the middle is not a possible value
				right = middle -1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 5, 6, 8, 10};
		System.out.println(binarySearch(array, 4));
		System.out.println(binarySearch(array, 5));
	}
}
