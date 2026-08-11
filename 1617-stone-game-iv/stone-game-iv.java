class Solution {
    int[] t;
    public boolean winnerSquareGame(int n) {
        t = new int[n+1];
        Arrays.fill(t , -1);

        return solve(n);   //Alice k lie call hai ye. If it's true, Alice wins, else Alice looses
    }
    public boolean solve(int n){
        if(n == 0){
            return false;
        }

        if(t[n] != -1){
            return t[n] == 0 ? false : true;
        }

        for(int k = 1 ; k*k <= n ; k++){  
            
            if(solve(n-k*k) == false){  //Call for Bob //False - Bob lost it
                //Alice won the game
                t[n] = 1;
                return true;
            }
        }   
        t[n] = 0;
        return false;    //Alice could never win. Lost it.
    }
} //T.C : O(n * sqrt(n))
//S.C : O(n)