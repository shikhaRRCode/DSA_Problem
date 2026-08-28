class Solution {
    int[][] dp;
    public int countSubstrings(String s) 
    {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];

        int count = 0;
        for(int L = 1 ; L <= n ; L++){
            for(int i = 0 ; i + L - 1 < n ; i++){
                int j = i+L-1;

                if(i == j){         //1 Length substring
                    dp[i][j] = true;
                }
                else if(i+1 == j){     //2 Length substring
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? true : false;
                }
                else{              //general length substring
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) ? true : false;
                }

                if(dp[i][j]){
                    count++;
                }

            }
        }
        return count;
    }   
}
//State Def : 
//d[i][j] -> true  means substring (i,j) -> is palindrome
//        -> false means substring (i,j) -> not a palindrome

// Note : all 1 length substring are palindrome (i.e all diagonal elements are true of dp