class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int counter = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) { 
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    counter = Math.max(counter, dp[i][j]);
                }
            }
        }
        
        return counter * counter;
    }
}


/*
Idea: I want to keep a running maximum square area.
dp[i][j] represents the length of the current maximum square I have.
This is equal to the one above i,j; the one left of i,j; and the one diagonal up left. All of these plus 1 because I'm including the current cell.

*/
