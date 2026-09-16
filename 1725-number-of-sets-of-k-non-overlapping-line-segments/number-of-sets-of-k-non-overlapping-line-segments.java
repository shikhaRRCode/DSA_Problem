class Solution {
    int[][] dp;
    int MOD = 1000000007;
    public int numberOfSets(int n, int k) {
        dp = new int[n+1][k+1];
        for(int[] arr : dp)  Arrays.fill(arr , -1);

        return solve(n , k , 0) % MOD;
    }
    public int solve(int n , int k , int i){
        if(k == 0)   return 1;
        
        if(i >= n)   return 0;

        if(dp[i][k] != -1){
            return dp[i][k];
        }

        //skip
        long skip = (solve(n , k , i+1) % MOD);

        //take --> start line sgement from i
        long take = 0;
        for(int j = i+1 ; j < n ; j++){
            take += (solve(n , k-1 , j) % MOD);
        }

        return dp[i][k] = (int)((skip + take) % MOD);
    }
}
//We have option
// 1. Whether to skip the current point i
// 2. start line segment from point i