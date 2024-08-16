
class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
          int n=matrix.length;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==-1)
                  matrix[i][j]=Integer.MAX_VALUE;
                if(i==j)
                  matrix[i][j]=0;
            }
        }
        
        //Main code
        for(int v=0;v<n;v++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(matrix[i][v]!=Integer.MAX_VALUE && matrix[v][j]!=Integer.MAX_VALUE) 
                    {
                      matrix[i][j]=Math.min(matrix[i][j],(matrix[i][v]+matrix[v][j]));
                    }
                }
            }
        }
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==Integer.MAX_VALUE)
                  matrix[i][j]= -1;
                
            }
        }
    }
}