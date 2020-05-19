class SingleElementInSortedArray { 
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        if (nums.length == 1) return nums[0];
        
        if (nums[right] != nums[right - 1]) {
            return nums[right];
        }
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (middle % 2 == 0) {
                if (middle + 1 < nums.length && nums[middle] == nums[middle + 1]) {
                    left = middle;
                }
                else if (middle - 1 >= 0 && nums[middle] == nums[middle - 1]) {
                    right = middle;
                }
                else {
                    return nums[middle];
                }
            }
            else {
            
                if (middle + 1 < nums.length && nums[middle] == nums[middle + 1]) {
                    right = middle;
                }
                else if (middle - 1 >= 0 && nums[middle] == nums[middle - 1]) {
                    left = middle;
                }

                else {
                    return nums[middle];
                }
            }
        }
        
        return nums[0] == nums[1] ? nums[nums.length - 1] : nums[0];
    }
}
