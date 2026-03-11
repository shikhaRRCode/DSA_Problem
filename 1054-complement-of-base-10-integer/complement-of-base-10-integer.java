class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;

        int result = 0;
        int count = 0;
        while(n > 0)
        {
            int rem = n % 2;

            // flip the bit (0 -> 1 , 1 -> 0)
            // and add its value at correct binary position
            result += Math.pow(2 , count++) * (rem == 0 ? 1 : 0);

            // remove the processed bit
            n/=2;
        }   
        return result;
    }                          //T.C = O(log n)
}