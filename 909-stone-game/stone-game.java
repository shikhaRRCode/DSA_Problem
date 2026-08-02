class Solution {
    int[][] dp;
    int n ;
    public boolean stoneGame(int[] piles) {
        n = piles.length;
        dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }

        int total = 0;
        for(int val : piles){
            total += val;
        }

        int Alice = solve(piles , 0 , n-1);
        int Bob = total - Alice;

        return Alice > Bob; 
    }
    public int solve(int[] piles , int i , int j){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int take_left = piles[i] + Math.min(solve(piles,i+2,j) , solve(piles,i+1,j-1));
        int take_right = piles[j] + Math.min(solve(piles,i+1,j-1)  , solve(piles,i,j-2));

        return dp[i][j] = Math.max(take_left , take_right);
    }
}