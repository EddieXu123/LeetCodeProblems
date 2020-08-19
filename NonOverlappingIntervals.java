class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int k = 0;
        int n = intervals.length;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[k][1]) {
                k = i;
                count++;
                
            }
        }
        
        return n - count;
    }
}
