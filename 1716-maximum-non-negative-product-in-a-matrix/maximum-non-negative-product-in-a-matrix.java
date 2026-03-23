class Solution {
    int m, n;
    Long[][][] dp; // dp[i][j][0]=max , dp[i][j][1]=min
    int mod = 1000000007;
    public int maxProductPath(int[][] grid) 
    {
        m = grid.length;
        n = grid[0].length;

        dp = new Long[m][n][2];

        long[] res = solve(grid, 0, 0);

        if (res[0] < 0) return -1;
        return (int)(res[0] % mod);
    }
    public long[] solve(int[][] grid, int i, int j) {
        // out of bounds
        if (i >= m || j >= n) return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};

        // last cell
        if (i == m - 1 && j == n - 1)
            return new long[]{grid[i][j], grid[i][j]};

        // already computed
        if (dp[i][j][0] != null)
            return new long[]{dp[i][j][0], dp[i][j][1]};

        long[] down = solve(grid, i + 1, j);
        long[] right = solve(grid, i, j + 1);

        long val = grid[i][j];

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        // try all 4 combinations
        // use only valid values
        if (down[0] != Long.MIN_VALUE) {
            max = Math.max(max, down[0] * val);
            min = Math.min(min, down[0] * val);
        }
        if (down[1] != Long.MAX_VALUE) {
            max = Math.max(max, down[1] * val);
            min = Math.min(min, down[1] * val);
        }
        if (right[0] != Long.MIN_VALUE) {
            max = Math.max(max, right[0] * val);
            min = Math.min(min, right[0] * val);
        }
        if (right[1] != Long.MAX_VALUE) {
            max = Math.max(max, right[1] * val);
            min = Math.min(min, right[1] * val);
        }

        dp[i][j][0] = max;
        dp[i][j][1] = min;

        return new long[]{max, min};
    }
}