class Solution {
    int[][][] dp;
    int n , m;
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m+1][n+1][n+1];
        for(int[][] arr : dp){
            for(int[] subarr : arr){
                Arrays.fill(subarr , -1);
            }
        }

        return solve(grid , 0 , 0 , n-1);
    }
    public int solve(int[][] grid , int row , int c1 , int c2){
        if(row >= m){
            return 0;
        }

        if(dp[row][c1][c2] != -1){
            return dp[row][c1][c2];
        }

        int cherry = grid[row][c1];
        if(c1 != c2){
            cherry += grid[row][c2];
        }

        int ans = 0;
        for(int i = -1 ; i <= 1 ; i++){
            for(int j = -1 ; j <= 1 ; j++){
                int new_row = row + 1;
                int new_c1 = c1 + i;
                int new_c2 = c2 + j;

                if(new_c1 >= 0 && new_c1 < n && new_c2 >= 0 && new_c2 < n ){
                    ans = Math.max(ans , solve(grid , new_row , new_c1 , new_c2));
                }

            }
        }
        return dp[row][c1][c2] =  cherry + ans; 
    }
}