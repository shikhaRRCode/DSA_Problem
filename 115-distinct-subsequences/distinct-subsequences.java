class Solution {
    int n , m;
    int[][] dp;
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }

        return solve(s , t , 0 , 0);
    }
    public int solve(String s , String t , int i , int j){
        //Base cases:
        if(j == m){
            return 1;
        }
        if(i == n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int count = 0;
        //match
        if(s.charAt(i) == t.charAt(j)){
            //take
            count += solve(s , t , i+1 , j+1); 

        }

        //not match
        count += solve(s , t , i+1 , j);

        return dp[i][j] =  count;
    }
}