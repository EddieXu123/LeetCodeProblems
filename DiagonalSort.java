class DiagonalSort {
    public int[][] diagonalSort(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                swapMinValueInDiag(matrix, i, j);
            }
        }
        
        return matrix;
    }
    

    public void swapMinValueInDiag(int[][] matrix, int x, int y) {
        int iIndex = x;
        int jIndex = y;
        
        int height = matrix.length;
        int width = matrix[0].length;
        
        int min = matrix[x][y];
        
        int outOfBounds = Math.min(height - x, width - y); // Most I can go is 2 diag
        
        for (int i = 0; i < outOfBounds; i++) {
            if (matrix[x + i][y + i] < min) {
                iIndex = x + i;
                jIndex = y + i;
                min = matrix[x + i][y + i];
            }
        }
        
        swap(matrix, iIndex, jIndex, x, y);
    }
    
    public void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}


/*

3 3 1 1 
2 2 1 2
1 1 1 2


2 1 1 1
2 3 3 2
1 1 1 2

1 1 1 1
1 2 2 2
1 2 3 3 


2 1
2 1

2 1
2 1

1 1
2 2

For each cell, I want to sort all the cells from 

currentCell --> mat[i][j]
mat[i+1][j+1] ... until I reach out of bounds.


What is out of bounds? 

let x = matrix.length
let y = matrix[0].length

If my current cell is at index i, j. Then my out of bounds index is min(y - j, x - i)


Let's say I iterate through every cell in my matrix. For each cell, I call a helper function that replaces the current cell with the min of all the cells from currentCell to diagBottomRight.


For example 1, I start at 3, then look for the min value in cell[0][0], cell[1][1], cell[2][2], which is 1. I then swap these two cells in place


Helper function:

void swapMinValueInDiag(matrix, i, j):
    x = len(matrix)
    y = len(matrix[x])
    
    outOfBounds = min(y - j, x - i)
    min = matrix[i][j]
    iIndex = i
    jIndex = j
    
    for (v = i to i + outOfBounds):
        for (w = j to j + outOfBounds):
            if (matrix[v][w] < min):
                iIndex = v
                jIndex = j
                min = matrix[v][w]
                
    swap(matrix[i][j], matrix[iIndex][jIndex])
    
    
    What this does is for the current cell, it places the min value in that diagonal in that current cell
    
    I can just iterate through my matrix now.
                







*/
