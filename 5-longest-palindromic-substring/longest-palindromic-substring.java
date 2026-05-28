class Solution {;
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        int maxLength = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(solve(s , i , j)){
                    if(j-i+1 > maxLength){
                        ans = s.substring(i , j+1);
                        maxLength = Math.max(maxLength , j-i+1);
                    }
                }
            }
        }
        return ans;
    }
    public boolean solve(String s , int i , int j){
        if(i >= j){
            return true;
        }

        if(s.charAt(i) == s.charAt(j)){
            return solve(s , i+1 , j-1);
        }
        else{
            return false;
        }
    }
}