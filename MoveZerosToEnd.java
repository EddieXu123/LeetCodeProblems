class MoveZeros {
    public void moveZeroes(int[] nums) {
        int counter = 0; // counts the number of zeros in the array
        int nonZero = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZero] = nums[i];
                nonZero++;
            }
            else {
                counter++;
            }
        }
        
        for (int i = nums.length - 1; i > nums.length - 1 - counter; i--) {
            nums[i] = 0;
        }
    }
    
    // Keep track of where the zeros are and where the nonzeros are, and swap the two
    public void moveZeroes(int[] nums) {

        int j = 0; // You can just swap the nonzero with the zero elements until the zeros are at the end
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}
