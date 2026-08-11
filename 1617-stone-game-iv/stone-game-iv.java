class Solution {
    int[] t;
    public boolean winnerSquareGame(int n) {
        t = new int[n+1];
        Arrays.fill(t , -1);

        return solve(n); 
    }
    public boolean solve(int n){
        if(n == 0){
            return false;
        }

        if(t[n] != -1){
            return t[n] == 0 ? false : true;
        }

        for(int k = 1 ; k*k <= n ; k++){
            if(solve(n-k*k) == false){
                t[n] = 1;
                return true;
            }
        }   
        t[n] = 0;
        return false;
    }
}