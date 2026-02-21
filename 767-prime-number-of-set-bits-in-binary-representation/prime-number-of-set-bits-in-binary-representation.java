class Solution {
    public int countPrimeSetBits(int left, int right) 
    {
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