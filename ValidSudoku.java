class ValidSudoku {

    // Basic Idea: Go through each cell on the board. If it's is a number, check the column, row, and subsquare it's in for repeats.
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && 
                    !(validSquare(board, i, j) && validRowCol(board, i, j))) return false;
            }
        }
        
        return true;
    }
    
    public boolean validSquare(char[][] board, int x, int y) {
        char current = board[x][y];
        board[x][y] = '0';
        
        if (x % 3 == 0) { // It is the leftmost column of the square
            if (y % 3 == 0) { // I'm in the top left corner of the box
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        if (board[i][j] == current) return false;
                    }
                }
            }
            
            else if (y % 3 == 1) { // I'm in the "down one from top left" box 
                for (int i = x; i < x + 3; i++) {
                    for (int j = y - 1; j < y + 2; j++) {
                        if (board[i][j] == current) return false;
                    }
                }
            }
            
            else {
                for (int i = x; i < x + 3; i++) {
                    for (int j = y - 2; j < y + 1; j++) {
                        if (board[i][j] == current) return false;
                    }
                }
            }
        }
        
        else if (x % 3 == 1) { // It is the middle column of the square
            if (y % 3 == 0) { 
                for (int i = x - 1; i < x + 2; i++) {
                    for (int j = y; j < y + 3; j++) {
                        if (board[i][j] == current) return false;
                    }
                }
            }
            
            else if (y % 3 == 1) {  // It's the middle of the square
                for (int i = x - 1; i < x + 2; i++) {
                    for (int j = y - 1; j < y + 2; j++) {
                        if (board[i][j] == current) return false;
                    }
                }
            }
            
            else {
                for (int i = x - 1; i < x + 2; i++) {
                    for (int j = y - 2; j < y + 1; j++) {
                        if (board[i][j] == current) return false;
                    }
                }
            }
        }
        
        else { // It is the right column of the square
            if (y % 3 == 0) { // I'm in the top left corner of the box
                for (int i = x - 2; i < x + 1; i++) {
                    for (int j = y; j < y + 3; j++) {
                        if (board[i][j] == current) return false;
                    }
                }
            }
            
            else if (y % 3 == 1) { // I'm in the "down one from top left" box 
                for (int i = x - 2; i < x + 1; i++) {
                    for (int j = y - 1; j < y + 2; j++) {
                        if (board[i][j] == current) return false;
                    }
                }
            }
            
            else {
                for (int i = x - 2; i < x + 1; i++) {
                    for (int j = y - 2; j < y + 1; j++) {
                        if (board[i][j] == current) return false;
                    }
                }
            }
        }
        
        board[x][y] = current;
        return true;
    }
    
    public boolean validRowCol(char[][] board, int x, int y) {
        char current = board[x][y];
        board[x][y] = '0';
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == current) return false;
        }
        
        for (int i = 0; i < board[0].length; i++) {
            if (board[x][i] == current) return false;
        }
        
        board[x][y] = current;
        return true;
    }
}
