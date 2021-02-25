class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != arr[i]) {
                left = i;
                break;
            }
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != arr[i]) {
                right = i;
                break;
            }
        }
        
        return left == right? 0 : right - left + 1;
    }
}

/*
O(n) solution - followup

    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int end = -2;
        int start = -1;
        int max = nums[0];
        int min = nums[right];
        
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[right - i], min);
            if (nums[right - i] > min) {
                start = right - i;
            }
            if (nums[i] < max) {
                end = i;
            }
        }
        return end - start + 1;
    }





*/
