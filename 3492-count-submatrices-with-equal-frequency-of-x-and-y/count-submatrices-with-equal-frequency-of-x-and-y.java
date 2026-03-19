class Solution {
    public int numberOfSubmatrices(char[][] grid) 
    {
        int n = grid.length;
        int m = grid[0].length;

        // prefix sum arrays to count X and Y separately
        int[][] cumSumX = new int[n][m];
        int[][] cumSumY = new int[n][m];

        int count = 0;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                // mark 1 if current cell is X or Y
                cumSumX[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                cumSumY[i][j] = (grid[i][j] == 'Y') ? 1 : 0;

                // build prefix sum for X
                if(i > 0)   cumSumX[i][j] += cumSumX[i-1][j];
                if(j > 0)   cumSumX[i][j] += cumSumX[i][j-1];
                if(i > 0 && j > 0)   cumSumX[i][j] -= cumSumX[i-1][j-1];

                // build prefix sum for Y
                if(i > 0)   cumSumY[i][j] += cumSumY[i-1][j];
                if(j > 0)   cumSumY[i][j] += cumSumY[i][j-1];
                if(i > 0 && j > 0)   cumSumY[i][j] -= cumSumY[i-1][j-1];


                //Check : an equal frequency of 'X' and 'Y' AND at least one 'X'.
                if(cumSumX[i][j] == cumSumY[i][j] && cumSumX[i][j] > 0){
                    count++;
                }
            }
        }
        
        return count;
    }
}