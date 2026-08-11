class Solution {
    int[] t;
    public boolean winnerSquareGame(int n) {

        boolean[] t = new boolean[n+1];
        //Base case . n == 0, return false
        t[0] = false; //base case

        //Bottom-up :Tabulation
        for(int i = 0 ; i < n+1 ; i++){
            for(int k = 1 ; k*k <= i ; k++){
                if(t[i-k*k] == false){
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n];
    }
}
//T.C : O(n * sqrt(n))
//S.C : O(n)