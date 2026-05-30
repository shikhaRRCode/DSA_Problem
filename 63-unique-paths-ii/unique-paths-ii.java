class Solution {
    int n , m;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n = obstacleGrid.length;
        m = obstacleGrid[0].length;

        //Creating dp
        dp = new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return totalPaths(0 , 0 , obstacleGrid);
    }
    public int totalPaths(int i ,int j , int[][] grid){
        // Base Case 1: Out of bounds or hitting an obstacle
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 1){
            return 0;
        }

        // Base Case 2: Reached the destination
        if(i == n-1 && j == m-1){
            return 1;
        }

        // Check if the result is already memoized (-1 means unvisited)
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // Recursive moves
        int down = totalPaths(i+1 , j , grid);
        int right = totalPaths(i , j+1, grid);

        // Memoize and return the result
        return dp[i][j] = down + right;
    } 
}