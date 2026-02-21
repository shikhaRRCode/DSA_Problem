class Solution {
    public int countPrimeSetBits(int left, int right) 
    {
        int count = 0;
        for(int i = left ; i <= right ; i++)
        {
            int num = Integer.bitCount(i);
            //checking prime
            if(prime(num)){
                count++;
            }
        }    
        return count;
    }
    public boolean prime(int num)
    {
        if(num <= 0)
        return false;
        int count = 0;
        for(int i = 1 ; i <= num ; i++)
        {
            if(num % i == 0)
            count++;
        }
        return count == 2;
    }
}