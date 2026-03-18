class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                // build prefix sum (sum from (0,0) to (i,j))
                if(i > 0) grid[i][j] += grid[i-1][j];
                if(j > 0) grid[i][j] += grid[i][j-1];
                if(i > 0 && j > 0) grid[i][j] -= grid[i-1][j-1];

                if(grid[i][j] <= k ){
                    count++;
                } 
                else{
                    // since values increase in row, no need to check further in this row
                    break;          //break inner loop
                }
            }
        }
        return count;
    }
}