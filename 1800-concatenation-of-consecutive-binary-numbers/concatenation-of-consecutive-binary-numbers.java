class Solution {
    public int concatenatedBinary(int n) 
    {
        long result = 0;
        int MOD = 1000000007;          // used to prevent overflow
        int digits = 0;
        for(int num = 1 ; num <= n ; num++)
        {
            //Finding whether a number is power of 2 or not
            //beacuse at power 2 , no. of digits to represent number in binary increases by 1
            if((num & (num-1)) == 0)
            {
                digits++;
            }

            // shift result left to make space and add current number
            result = ((result << digits) + num) % MOD;
        }    
        return (int)result;
    }
}