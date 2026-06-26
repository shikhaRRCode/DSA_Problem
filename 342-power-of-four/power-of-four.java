class Solution {
    public boolean isPowerOfFour(int n) {
        // 1. n must be positive
        // 2. n & (n - 1) == 0 ensures it's a power of two
        // 3. (n - 1) % 3 == 0 ensures that power of two is specifically a power of four
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;       
    }
}
