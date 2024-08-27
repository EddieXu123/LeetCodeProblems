Intuition
Try to move any exceed stone in one cell to any other empty cell.
In the contest, I thought it is BFS/ multi source BFS, BFS from stones or BFS from empty cells. But it will not give the optimal solution.

Code
class Solution {
    public int minimumMoves(int[][] grid) {
        int minMoves = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] > 1) {
                    //try to move the exceeded stones
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            int curMove = 0;
                            if (grid[k][l] == 0) {
                                grid[k][l] = 1;
                                curMove += Math.abs(k - i) + Math.abs(l - j);
                                grid[i][j]--;
                                curMove += minimumMoves(grid);
                                grid[i][j]++;
                                grid[k][l] = 0;
                                minMoves = Math.min(minMoves, curMove);
                            }
                        }
                    }
                }
            }
        }

        return minMoves == Integer.MAX_VALUE ? 0 : minMoves;
    }
}
