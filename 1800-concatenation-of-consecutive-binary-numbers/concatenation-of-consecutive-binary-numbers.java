class Solution {
    public int concatenatedBinary(int n) 
    {
        long result = 0;
        int MOD = 1000000007;          // used to prevent overflow
        for(int num = 1 ; num <= n ; num++)
        {
            // find number of binary digits in current number
            int digits = (int)(Math.log(num)/Math.log(2)) + 1;

            // shift result left to make space and add current number
            result = ((result << digits) + num) % MOD;
        }    
        return (int)result;
    }
}