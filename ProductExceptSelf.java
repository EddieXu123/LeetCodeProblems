class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        
        int rightSide = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * rightSide;
            rightSide *= nums[i];
        }
        return output;
    }
}
