class Solution {
    int n , m;
    int[][] dp;
    public int countSquares(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];

        int result = 0;   //count number of square sub-matrices (having 1's) ending with [i][j]
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }
                else if(matrix[i][j] == 1){
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i-1][j-1] , dp[i][j-1]));
                }
                result+=dp[i][j];
            }
        }
        return result;
    }

}