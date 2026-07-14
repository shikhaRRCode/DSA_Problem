class Solution {
    int n , m;
    int[][] dp;
    public int countSquares(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1);
        }

        int result = 0;   //count number of square sub-matrices with only 1's in it
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(matrix[i][j] == 1){
                    result += solve(i , j , matrix , dp);
                }
            }
        }
        return result;
    }
    public int solve(int i , int j , int[][] grid , int[][] dp){
        if(i >= n || j >= m){
            return 0;
        }

        if(grid[i][j] == 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = solve(i+1 , j , grid , dp);
        int diagonal = solve(i+1 , j+1 , grid , dp);
        int left = solve(i , j+1 , grid , dp);

        return dp[i][j] = 1 + Math.min(right , Math.min(left , diagonal));
    }
}