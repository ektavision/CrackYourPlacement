class Solution {
    public int largestRectangleArea(int[] heights) {
      if(heights==null||heights.length==0) return 0;
      Stack<Integer> stHeight = new Stack<>();
      Stack<Integer> stIndex = new Stack<>();
      int max = 0;
      for (int i = 0; i < heights.length; i++) {
          if (stHeight.isEmpty()||heights[i] > stHeight.peek()){
              stHeight.push(heights[i]);
              stIndex.push(i);
          }else if(heights[i]<stHeight.peek()){
              int lastIndex = 0;
              while(!stHeight.isEmpty() && heights[i] < stHeight.peek()){
                  lastIndex = stIndex.pop();
                  int area = stHeight.pop()*(i-lastIndex);
                  max = Math.max(max,area);
              }
              stHeight.push(heights[i]);
              stIndex.push(lastIndex);    
          }
      }
      while(!stHeight.isEmpty()){
          int area = stHeight.pop()*(heights.length-stIndex.pop());
          max = Math.max(max,area);
      }
      return max;
  }
  public int maximalRectangle(char[][] matrix) {
      if(matrix==null||matrix.length==0||matrix[0]==null) return 0;
      int[] row = new int[matrix[0].length];
      int max = 0;
      for (int i = 0; i < matrix.length; i++) {
          for (int j = 0; j < matrix[0].length; j++) {
              if (Character.getNumericValue(matrix[i][j])==0){
                  row[j]=0;
              }else {
                  row[j]+=Character.getNumericValue(matrix[i][j]);
              }
          }
          max = Math.max(max,largestRectangleArea(row));
      }
      return max; 
  }
}