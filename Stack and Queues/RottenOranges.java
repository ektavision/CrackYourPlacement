
class Solution
{
    //Function to find minimum time required to rot all oranges. 
        private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid)
    {
        // Code here
         int n = grid.length;
        int m = grid[0].length; 
        int count = 0;
        int fresh_count =0;
        Queue<int[]> queue =  new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                   queue.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1) {
                  fresh_count++;
                }
            }
        }
        
       while(!queue.isEmpty()) {
           if(fresh_count == 0) {
               return count;
           }
             int size = queue.size();
             count++;
         for(int i=0; i<size; i++) { 
             int[] point = queue.poll();
             for(int[] dir: dirs) { 
                 int x = point[0] + dir[0];
                 int y = point[1] + dir[1];
                 if(x < 0 || x>= grid.length || y <0 || y >= grid[x].length || grid[x][y] == 2 || grid[x][y] == 0) {
                 continue;
             }
                 grid[x][y] =2;
                 queue.add(new int[]{x,y});
                 fresh_count--;
             }
         }
          
       }
       return fresh_count == 0 ? count : -1;
    }
}