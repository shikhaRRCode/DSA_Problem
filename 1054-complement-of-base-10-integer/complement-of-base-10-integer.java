class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;

        int mask = 1;
        while(mask < n){
            //leftShift Mask to make space for addition
            mask =  mask << 1;
            //add (or operator)
            mask = mask | 1;
        }
        //Xor operation : Ex : 101 ^ 111 = 010
        return n ^  mask;
    }                          //T.C = O(log n)
}