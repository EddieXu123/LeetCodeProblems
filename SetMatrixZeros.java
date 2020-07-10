class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        
        if (firstRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
