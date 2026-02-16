class Solution {
    public int reverseBits(int n) 
    {
        int result = 0;
        for(int i = 0 ; i < 32 ; i++)
        {
            //1. Fetch Leftmost bit of number
            int LSB = (n & 1);
            //2. Left shift result (to make space for LSB to add)
            result = result << 1;
            //2. add last bit on n (using or operator)
            result = result | LSB;
            n = n >> 1;
        }
        return result;
    }
}