class Solution {
    public boolean hasAlternatingBits(int n) 
    {
        int curr_bit = -1;
        while(n > 0)
        {
            if(curr_bit == (n%2))
            return false;

            curr_bit = n%2;
            n/=2;
        }
        return true;
            
    }
}