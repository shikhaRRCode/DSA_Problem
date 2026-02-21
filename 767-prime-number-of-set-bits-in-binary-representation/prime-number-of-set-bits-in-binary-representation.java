class Solution {
    public int countPrimeSetBits(int left, int right) 
    {
        // 2^10 --> 1024 --> 10^3 (approx)
        //10^6 --> 2^20  --> worst case 20 set-bits(so, store prime no. b/w 1-20)
        HashSet<Integer> set = new HashSet<>(Set.of(2,3,5,7,11,13,17,19));
        int count = 0;
        for(int i = left ; i <= right ; i++)
        {
            int num = Integer.bitCount(i);
            //checking prime
            if(set.contains(num)){
                count++;
            }
        }    
        return count;
    }
}