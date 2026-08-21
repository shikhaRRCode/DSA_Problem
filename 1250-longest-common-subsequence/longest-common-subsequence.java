class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        dp = new int[n+1][m+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
    
        return dp[n][m];
    }
    // public int solve(String s1 , String s2 , int n , int m){
    //     if(n == 0 || m == 0){
    //         return 0;
    //     }

    //     if(dp[n][m] != -1){
    //         return dp[n][m];
    //     }

    //     if(s1.charAt(n-1) == s2.charAt(m-1)){
    //         return dp[n][m] =  1 + solve(s1 , s2 , n-1 , m-1);
    //     }
        
    //     return dp[n][m] = Math.max(solve(s1 , s2 , n-1 , m) , solve(s1 , s2 , n , m-1));  
    // }
}
//STATE DEFINITION: dp[i][j] = longest common subsequence between s1 of length i and s2 of length j.