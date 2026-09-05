class Solution {
    int[] row = {0, 1}; // Right, Down
    int[] col = {1, 0};
    int n;
    int[][][][] dp;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        if (grid[0][0] == -1 || grid[n - 1][n - 1] == -1) {
            return 0;
        }

        dp = new int[n][n][n][n];
        for (int[][][] sub : dp) {
            for (int[][] sub_dp : sub) {
                for (int[] small_sub_dp : sub_dp) {
                    Arrays.fill(small_sub_dp, -2); // Use -2 for unvisited
                }
            }
        }

        int ans = solve(grid, 0, 0, 0, 0);
        return Math.max(0, ans);
    }

    public int solve(int[][] grid, int i, int j, int x, int y) {
        // Base Case: Reached target
        if (i == n - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j][x][y] != -2) {
            return dp[i][j][x][y];
        }

        int cherry = grid[i][j];
        if (i != x || j != y) {
            cherry += grid[x][y];
        }

        int maxNext = -1;

        for (int rob1 = 0; rob1 < 2; rob1++) {
            for (int rob2 = 0; rob2 < 2; rob2++) {
                int new_r1 = i + row[rob1];
                int new_c1 = j + col[rob1];
                int new_r2 = x + row[rob2];
                int new_c2 = y + col[rob2];

                if (isSafe(new_r1, new_c1, new_r2, new_c2) &&
                    grid[new_r1][new_c1] != -1 &&
                    grid[new_r2][new_c2] != -1) {

                    int next = solve(grid, new_r1, new_c1, new_r2, new_c2);
                    if (next != -1) { // Only take valid paths
                        maxNext = Math.max(maxNext, next);
                    }
                }
            }
        }

        if (maxNext == -1) {
            return dp[i][j][x][y] = -1;
        }

        return dp[i][j][x][y] = maxNext + cherry;
    }

    public boolean isSafe(int i, int j, int x, int y) {
        return i < n && j < n && x < n && y < n && i >= 0 && j >= 0 && x >= 0 && y >= 0;
    }
}