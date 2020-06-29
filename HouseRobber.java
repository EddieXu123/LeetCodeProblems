class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            int val = nums[i];
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + val);
        }
        
        int[] dpSkip = new int[n + 1];
        dpSkip[0] = 0;
        dpSkip[1] = 0;
        for (int i = 1; i < n; i++) {
            int val = nums[i];
            dpSkip[i + 1] = Math.max(dpSkip[i], dpSkip[i - 1] + val);
        }
        
        return Math.max(dp[n - 1], dpSkip[n]);
        
    }
}
