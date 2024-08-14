class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
          if(color == image[sr][sc]) return image;
        DFS(image, sr, sc, color, image[sr][sc]);
        return image;
    }
      private void DFS(int[][] image, int row, int col, int color, int oldColor) {
        if(row >= image.length || row < 0 || col >= image[0].length || col < 0  || image[row][col] != oldColor) return;
        
        
        image[row][col] = color;
        
        DFS(image, row - 1, col, color, oldColor);
        DFS(image, row + 1, col, color, oldColor);
        DFS(image, row, col-1, color, oldColor);
        DFS(image, row, col+1, color, oldColor);
    }
}