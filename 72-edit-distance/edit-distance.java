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

        return solve(word1 , word2 , 0 , 0);   
    }
    public int solve(String s1 , String s2 , int i , int j){
        //Base cases:
        if(i == m){
            return n-j;  //insertions
        }
        if(j == n){
            return m-i; //deletions
        }

        //2. DP check
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return solve(s1 , s2 , i+1 , j+1);
        }

        int insert = 1 + solve(s1 , s2 , i , j+1);
        int delete = 1 + solve(s1 , s2 , i+1 , j);
        int replace = 1 + solve(s1 , s2 , i+1 , j+1);

        return dp[i][j] =  Math.min(insert , Math.min(delete ,replace));
    }
}