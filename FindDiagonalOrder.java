class FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int[] output = new int[matrix.length * matrix[0].length];
        int row = 0;
        int col = 0;
        
        
        for (int i = 0; i < output.length; i++) {
            output[i] = matrix[row][col];
            
            // Go up-right if the sum of the indicies is even
            if ((row + col) % 2 == 0) {
                // For last column, go down          
                if (col == matrix[0].length - 1) row++;
                
                // For first row & non-last columns, go right
                else if (row == 0) col++;
                
                // For not first row & non-last columns, go up and to the right
                else {
                    col++;
                    row--;
                }
            }
            
            else {
                // Opposite
                if (row == matrix.length - 1) col++;
                else if (col == 0) row++;
                else {
                    row++;
                    col--;
                }
            }
        }
        
        return output;
    }
}



/*

2,4,5,8
1,3,6,7
0,2,3,4


M*N = 4*7

xxxxxxx
xxxxxxx
xxxxxxx
xxxxxxx

0,0

0,1
1,0

2,0
1,1
0,2


0,3
1,2
2,1
3,0

3,1
2,2
1,3
0,4



0,5
1,4
2,3
3,2

3,3
2,4
1,5
0,6

1,6
2,5
3,4

3,5
2,6

3,6


Pattern-

Rows:
Columns:


0,0
2,0



[2,4,1,0,3,5,8,6,2,3,7,4]

    0,0
0,1
1,0
    2,0
1,1
0,2
0,3
1,2
2,1
2,2
1,3
2,3






[2,4,1,3,5,8,6,7]


0,0
0,1
1,0
1,1
0,2
0,3
1,2
1,3


*/
