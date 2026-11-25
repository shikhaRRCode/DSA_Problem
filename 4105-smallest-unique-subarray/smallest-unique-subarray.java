class Solution {
    private static final long BASE = 1315423911L;
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];
        long[] pref1 = new long[n + 1];
        long[] pref2 = new long[n + 1];

        pow1[0] = pow2[0] = 1L;
        for (int i = 0; i < n; i++) {
            long val = nums[i] + 1L;
            pow1[i + 1] = (pow1[i] * BASE) % MOD1;
            pow2[i + 1] = (pow2[i] * BASE) % MOD2;
            pref1[i + 1] = (pref1[i] * BASE + val) % MOD1;
            pref2[i + 1] = (pref2[i] * BASE + val) % MOD2;
        }

        int low = 1;
        int high = n;
        int ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUniqueOfLength(mid, n, pref1, pref2, pow1, pow2)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean hasUniqueOfLength(
            int len,
            int n,
            long[] pref1,
            long[] pref2,
            long[] pow1,
            long[] pow2) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int start = 0; start + len <= n; start++) {
            int end = start + len;
            long h1 = (pref1[end] - (pref1[start] * pow1[len]) % MOD1 + MOD1) % MOD1;
            long h2 = (pref2[end] - (pref2[start] * pow2[len]) % MOD2 + MOD2) % MOD2;
            long combined = (h1 << 32) ^ (h2 & 0xffffffffL);
            freq.put(combined, freq.getOrDefault(combined, 0) + 1);
        }

        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}