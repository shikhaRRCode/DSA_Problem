class Solution {
    int[][] dp;
    public int countSubstrings(String s) 
    {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }

        int count=0;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i; j < n ; j++)
            {
                if(ispalindromic(s , i , j))
                {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean ispalindromic(String s , int i , int j)
    {
        if(i >= j){
            return true;
        }

        if(dp[i][j] != -1){
            return dp[i][j] == 1 ? true : false;
        }

        if(s.charAt(i) == s.charAt(j)){
            boolean check = ispalindromic(s , i+1 , j-1);
            dp[i][j] = check ? 1 : 0;
            return check;
        }
        return false;
    }    
}