class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int farthestJump = 0;
        int currentEndOfJumpGap = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthestJump = Math.max(farthestJump, i + nums[i]);
            if (i == currentEndOfJumpGap) {
                jumps++;
                currentEndOfJumpGap = farthestJump;
            }
        }

        return jumps;
    }
}
