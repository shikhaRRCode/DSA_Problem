class Solution {
    int m , n;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        //1. Creating dp
        dp = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }

        return solve(word1 , word2 , m , n);   
    }
    public int solve(String s1 , String s2 , int m , int n){
        //Base cases:
        if(m == 0){
            return n;  //insertions
        }
        if(n == 0){
            return m; //deletions
        }

        //2. DP check
        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return solve(s1 , s2 , m-1 , n-1);
        }

        int insert = 1 + solve(s1 , s2 , m , n-1);
        int delete = 1 + solve(s1 , s2 , m-1 , n);
        int replace = 1 + solve(s1 , s2 , m-1 , n-1);

        return dp[m][n] =  Math.min(insert , Math.min(delete ,replace));
    }
}