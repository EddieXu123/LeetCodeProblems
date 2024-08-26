class Solution {
    private static final int GATE = 0;
    private static final int ROOM = Integer.MAX_VALUE;
    private static final int[][] directions = 
        new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        
        int n = rooms.length;
        int m = rooms[0].length;
                
        // step1: find all gates
        Queue<int[]> queue = findAllGates(rooms);
    
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] direction : directions) {
                int i = cell[0] + direction[0];
                int j = cell[1] + direction[1];
                if (i < 0 || j < 0 || i >= n || j >= m || rooms[i][j] != ROOM) continue;
                
                rooms[i][j] = rooms[cell[0]][cell[1]] + 1;
                queue.offer(new int[]{i, j});
            }
        }
    }

    private Queue<int[]> findAllGates(int[][] rooms) {
        Queue<int[]> gates = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == GATE) {
                    gates.add(new int[]{i, j});
                }
            }
        }

        return gates;
    }
}
