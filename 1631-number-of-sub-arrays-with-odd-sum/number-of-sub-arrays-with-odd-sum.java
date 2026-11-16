class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        long ans = 0;
        int prefixSum = 0;
        
        // Initialize evenCount to 1 to account for an empty prefix (sum = 0)
        int evenCount = 1;
        int oddCount = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                // Even prefix sum minus any previous odd prefix sum yields an odd subarray sum
                ans = (ans + oddCount) % MOD;
                evenCount++;
            } else {
                // Odd prefix sum minus any previous even prefix sum yields an odd subarray sum
                ans = (ans + evenCount) % MOD;
                oddCount++;
            }
        }

        return (int) ans;
    }
}