class Solution {
    public boolean isUgly(int n) {
        // Ugly numbers must be positive integers
        if (n <= 0) {
            return false;
        }
        
        // Keep dividing by 2, 3, and 5 as long as possible
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        
        // If the remaining number is 1, then it only had 2, 3, and 5 as prime factors
        return n == 1;
    }
}
