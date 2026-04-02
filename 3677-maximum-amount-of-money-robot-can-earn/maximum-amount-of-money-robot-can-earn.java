class Solution {
    int[][][] dp;
    int n , m;
    public int maximumAmount(int[][] coins) {
        n = coins.length;
        m = coins[0].length;

        //1.Create
        dp = new int[n+1][m+1][3];
        for(int i = 0  ; i < n + 1 ; i++){
            for(int j= 0 ; j < m + 1 ; j++){
                for(int k = 0 ; k < 3 ; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return solve(coins , 0 , 0 , 2);
    }
    public int solve(int[][] coins , int i , int j , int neu){
        //Base case
        if(i == n-1 && j == m-1){
            if(coins[i][j] < 0 && neu > 0){
                return 0;
            }
            return coins[i][j];
        }

        //Edge case
        if(i >= n || j >= m){
            return Integer.MIN_VALUE;
        }

        //2. Check 
        if(dp[i][j][neu] != Integer.MIN_VALUE){
            return dp[i][j][neu];
        }

        //take
        int take = coins[i][j] + Math.max(solve(coins,i,j+1,neu) , solve(coins,i+1,j,neu));

        //skip
        int skip = Integer.MIN_VALUE;
        if(coins[i][j] < 0 && neu > 0){
            int skipDown = solve(coins , i , j+1 , neu-1);
            int skipRight = solve(coins , i+1 , j , neu-1);

            skip = Math.max(skipDown , skipRight);
        }

        return dp[i][j][neu] = Math.max(take , skip);
    }
}