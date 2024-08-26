class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> distinctIslands = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    getIslandLayout(grid, i, j, sb, 'o');
                    distinctIslands.add(sb.toString());
                }
            }
        }
        return distinctIslands.size();
    }

    private void getIslandLayout(int[][] grid, int x, int y, StringBuilder sb, char direction) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 0) return;
        grid[x][y] = 0;
        sb.append(direction);
        getIslandLayout(grid, x + 1, y, sb, 'd');
        getIslandLayout(grid, x - 1, y, sb, 'u');
        getIslandLayout(grid, x, y + 1, sb, 'r');
        getIslandLayout(grid, x, y - 1, sb, 'l');
        sb.append('b');
    }
}
