class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= min) {
                min = num;
            }
            else if (num <= mid) {
                mid = num;
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}



/*

Naive Idea: Have a helper method that takes in the array and start index. The value at the start index will be called "mid", and I will have two pointers that traverse outwards from the start index. If I get a value such that the element at my left pointer < mid, I stop. Then, I check for an element at my right pointer > mid and return true. I then use this helper function at every iteration of my intial array: O(n^2) time complexity.


Better: Just have two values. If my current element is <= than my first values, update the first value. Otherwise, if it is greater than my first value, check if it is <= my second value, updating the SECOND value if it is. If none of these cases are true, then you know you have a valid triplet.

*/
