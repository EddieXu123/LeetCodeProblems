class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];

        dp[0][0] = poured;

        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double excess = (dp[i][j] - 1) / 2.0;
                    dp[i + 1][j] += excess;
                    dp[i + 1][j + 1] += excess;
                    dp[i][j] = 1;
                }
            }
        }

        return Math.min(dp[query_row][query_glass], 1.0);
    }
}



/*


You should first get the number of cups in the row before queryRow


if this number is > poured, you can return 0;

Else:
    you can trickle


(poured - NumCupsAbove) / numCupsInRow

                    1
                1       1
            1       1       1
        1       1       1       1


(1 + queryRow)

cup number you are on is:

1+2+3+4+5+...

numCups = 1;

for (int i = 1; i <= queryRow + 1; i++) {
    numCups += queryRow;
}

while (queryRow >= 0) {
    numCups += (queryRow + 1);
    queryRow--;
}





*/
