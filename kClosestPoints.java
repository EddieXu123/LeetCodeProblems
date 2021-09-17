class KClosestPoints {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> getDistance(a) - getDistance(b));
        
        for (int[] point : points) {
            pq.add(point);
        }
        
        int[][] output = new int[K][2];
        int counter = 0;
        
        while (K > 0) {
            int[] top = pq.poll();
            output[counter++] = top;
            K--;
        }
        
        return output;
    }
    
    public int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
