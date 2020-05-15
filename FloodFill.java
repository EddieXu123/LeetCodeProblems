/*An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
*/
import java.util.Arrays;

public class FloodFill {
  
  
  public static int[][] floodFill(int[][] matrix, int sr, int sc, int newColor) {
    if (matrix[sr][sc] == newColor) return matrix;
    fill(matrix, sr, sc, matrix[sr][sc], newColor);
    return matrix;
  }
  
  public static void fill(int[][] matrix, int x, int y, int current, int newColor) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] != current) 
      return;
    
    matrix[x][y] = newColor;
    fill(matrix, x + 1, y, current, newColor);
    fill(matrix, x - 1, y, current, newColor);
    fill(matrix, x, y + 1, current, newColor);
    fill(matrix, x, y - 1, current, newColor);
  }
}
