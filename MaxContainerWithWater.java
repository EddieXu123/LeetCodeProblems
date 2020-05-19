class MaxContainerWithWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = 0;
        
        while (start < end) {
            max = Math.max(max, Math.min(height[end], height[start]) * (end - start));
            if (height[start] > height[end]) end--;
            else {
                start++;
            }
        }
        
        return max;
    }
}
