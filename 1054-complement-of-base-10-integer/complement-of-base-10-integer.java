class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;

        // find number of bits in n using log base 2
        int bits = (int)Math.floor(Math.log(n) / Math.log(2)) + 1;

        int mask = (1 << bits) - 1;  //Math.pow(2 , bits) - 1 = 11....1;
        
        // XOR with mask flips all bits
        return n ^ mask;
    }                          //T.C = O(1)
}