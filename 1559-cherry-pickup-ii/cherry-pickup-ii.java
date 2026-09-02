class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //dp[row][c1][c2] : max cherry collected till rob1 is on grid[row][c1] && rob2 is on grid[row][c2] 
        int[][][] dp = new int[m+1][n+1][n+1];

        //For first row (robot1 is in 0th column) and robot2 is in (n-1)th column
        dp[0][0][n-1] = n == 1 ? grid[0][0] : grid[0][0] + grid[0][n-1];

        for(int row = 1 ; row < m ; row++){
            for(int c1 = 0 ; c1 <= Math.min(row ,n-1) ; c1++){
                for(int c2 = Math.max(0 , n-row-1) ; c2 < n ; c2++){

                    int prevMax = 0;
                    //A Robot can come to current column from either column-1, column, or column+1 of prev row (row-1)
                    for(int i = Math.max(0 , c1-1) ; i <= Math.min(n-1 , c1+1) ; i++){
                        for(int j = Math.max(0 , c2-1) ; j <= Math.min(n-1 , c2+1) ; j++){
                            prevMax = Math.max(prevMax , dp[row-1][i][j]);
                        }
                    }

                    if(c1 == c2){
                        dp[row][c1][c2] = prevMax + grid[row][c1];
                    }
                    else{
                        dp[row][c1][c2] = prevMax + grid[row][c1] + grid[row][c2];
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                ans = Math.max(ans , dp[m-1][i][j]);
            }
        }
        return ans;
    }
}
//T.C : O(row*col*col * 9)
//S.C : O(row * col * col)