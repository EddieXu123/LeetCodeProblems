public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        // Holds onto sum frequencies already passed
        Map<Integer, Integer> preSum = new HashMap<>();
        // Initialize map because if we reach a sum that equals zero, we can update result by 1 (sum equals zero because we check if map contains sum - k)
        preSum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            // Running sum of the subarray
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                // Append the frequency of the sum to our result
                result += preSum.get(sum - k);
            }
            // Add this sum and frequency to our map
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return result;
    }
}
