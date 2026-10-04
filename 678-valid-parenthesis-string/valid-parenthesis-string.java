class Solution {
    int n;
    int[][] dp;
    public boolean checkValidString(String s) {
        n = s.length();
        dp = new int[101][101];
        for(int[] arr : dp){
            Arrays.fill(arr , -1);
        }

        return solve(0 , 0 , s);
        
    }
    public boolean solve(int idx , int openBracket , String s){
        if(idx == n){
            return openBracket == 0;
        }

        if(dp[idx][openBracket] != -1){
            return dp[idx][openBracket] == 1;
        }

        boolean isValid = false;
        if(s.charAt(idx) == '('){
            isValid = solve(idx+1 , openBracket+1 , s);
        }
        else if(s.charAt(idx) == '*'){
            // '*' as '('
            isValid |= solve(idx+1 , openBracket+1 , s);
            // '*' as ''
            isValid |= solve(idx+1 , openBracket , s);
            // '*' as ')'
            if(openBracket > 0)
            isValid |= solve(idx+1 , openBracket-1 , s);
        }
        else if(s.charAt(idx) == ')' && openBracket > 0){
            isValid = isValid || solve(idx+1 , openBracket-1 , s);
        }

        dp[idx][openBracket] = isValid ? 1 : 0;
        return isValid;
    }
}