class Solution {
    int MOD = 1000000007;
    public int numberOfSets(int n, int K) {
        long[][] dp = new long[K+1][n+1];
        //dp[k][i] :k No. of line segments left , when we are on ith point
        

        //Base case: for k == 0 , we get one valid way
        for(int i = 0 ; i < n ; i++){
            dp[0][i] = 1;
        }

        for(int k = 1 ; k <= K ; k++){
            long[] prevRowSuffixSum = new long[n+1];
            for(int x = n-1 ; x >= 0 ; x--){
                prevRowSuffixSum[x] = (prevRowSuffixSum[x+1] + dp[k-1][x]) % MOD; 
            }

            for(int i = n-1 ; i >= 0 ; i--){
                //skip
                long skip = (dp[k][i+1] % MOD);

                //take
                long take = prevRowSuffixSum[i+1];

                dp[k][i] = (skip + take % MOD);
            }
        }
        return (int)(dp[K][0] % MOD);
    }
}
//We have option
// 1. Whether to skip the current point i
// 2. start line segment from point i