class JumpGame {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }
        
        return true;
    }
}
        
/*

I'm running from a villain who is chasing me, if this villain ever catches me, I return false.
Because I can jump, I want to jump as far as possible. If the villain catches me (while he goes 1 step at a time), this
means that I am basically stuck (or I've reached a zero). Other wise, I want to jump the maximum I can (which is where I currently 
am plus the number of jumps I can jump at this index)


        if (nums.length == 1) return true;
        
        int index = 0;
        
        
        // [2,3,1,1,4]
        // [3,2,1,0,4]
        // [3,3,0,0,2,0,1]
        // [3,4,3,3,0,0,1]
        
        while (index < nums.length - 1) {
            if (nums[index] == 0) return false;
            System.out.println(findMaxIndex(nums, index + 1, index + nums[index] + 1));
            index = findMaxIndex(nums, index + 1, index + nums[index] + 1);
        }
        
        return index >= nums.length - 1;
    }
    
    public int findMaxIndex(int[] nums, int start, int end) {
        int index = start - 1;
        int max = Integer.MIN_VALUE;
        
        for (int i = start; i < end; i++) {
            if (i < nums.length && nums[i] > max) {
                
                max = nums[i];
                index = i;
            }
        }
        
        index = index == start - 1 ? index + nums[index] : index;
        
        return index;
    }
}



/*





Idea: If you land on a zero, you are donezo.

Dynamic programming: 

*/
