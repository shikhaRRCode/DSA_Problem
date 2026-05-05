class Solution {
    // memoization array to store result of each index
    int[] dp;
    public int jump(int[] nums) 
    {
        int n = nums.length;
        dp = new int[n];
        // initialize memo with -1 (not computed yet)
        Arrays.fill(dp , -1);

        return solve(nums , n , 0);
    }
    public int solve(int[] nums, int n, int idx) {

        // reached end → no more jumps needed
        if (idx >= n - 1) {
            return 0;
        }

        // already computed
        if (dp[idx] != -1) {
            return dp[idx];
        }

        int minJump = Integer.MAX_VALUE;

        // try all jumps
        for (int i = 1; i <= nums[idx]; i++) {

            int next = solve(nums, n, idx + i);

            // valid path
            if (next != Integer.MAX_VALUE) {
                minJump = Math.min(minJump, 1 + next);
            }
        }

        return dp[idx] = minJump;
    }  
}