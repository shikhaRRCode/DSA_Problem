class Solution {
    int M = (int)1e9 + 7;
    int[][][] t = new int[201][201][2];
    public int numberOfStableArrays(int zero, int one, int limit) 
    {
        // initialize DP with -1
        for(int i = 0; i <= 200; i++){
            for(int j = 0; j <= 200; j++){
                Arrays.fill(t[i][j], -1);
            }
        }
        int startWithOne = solve(one , zero , false , limit);
        int startWithZero = solve(one ,zero , true , limit);

        return (startWithOne + startWithZero) % M;    
    }
    public int solve(int onesLeft , int zeroesLeft , boolean lastWasOne , int limit)
    {
        // if no elements left → valid array
        if(onesLeft == 0 && zeroesLeft == 0){
            return 1;
        }

        int last = lastWasOne ? 1 : 0;
        // memoization
        if(t[onesLeft][zeroesLeft][last] != -1){
            return t[onesLeft][zeroesLeft][last];
        }

        long result = 0;
        if(lastWasOne == true){
            //explore 0's
            for(int len = 1 ; len <= Math.min(zeroesLeft , limit) ; len++)
            {
                result = (result + solve(onesLeft , zeroesLeft - len , false , limit)) % M;
            }
        }
        else{
            //explore 1's
            for(int len = 1 ; len <= Math.min(onesLeft , limit) ; len++)
            {
                result = (result + solve(onesLeft - len , zeroesLeft , true , limit)) % M;
            }
        }
        return t[onesLeft][zeroesLeft][last] = (int)result;
    }
}