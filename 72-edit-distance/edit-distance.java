class Solution {
    int m , n;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        //Bottom-UP
        dp = new int[m+1][n+1];

        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ;j++){
                if(i == 0  || j == 0){
                    dp[i][j] =i+j;
                }
                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; 
                }
                else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(insert , Math.min(delete , replace));
                }
            }
        }
        return dp[m][n];  
    }
    // public int solve(String s1 , String s2 , int m , int n){
    //     //Base cases:
    //     if(m == 0 || n == 0){
    //         return m + n; 
    //     }
    //
    //     //2. DP check
    //     if(dp[m][n] != -1){
    //         return dp[m][n];
    //     }

    //     if(s1.charAt(m-1) == s2.charAt(n-1)){
    //         return solve(s1 , s2 , m-1 , n-1);
    //     }

    //     int insert = 1 + solve(s1 , s2 , m , n-1);
    //     int delete = 1 + solve(s1 , s2 , m-1 , n);
    //     int replace = 1 + solve(s1 , s2 , m-1 , n-1);

    //     return dp[m][n] =  Math.min(insert , Math.min(delete ,replace));
    // }
}

//State definition
//dp[i][j] = minimum operations for making s1 of length i an s2 of length j equal