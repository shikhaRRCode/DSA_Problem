class Solution {
    int m, n;
    Boolean[][][] memo;
    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // Max possible XOR for values up to 1023 is less than 1024
        memo = new Boolean[m][n][1024];
        
        int minXor = Integer.MAX_VALUE;
        for (int xor = 0; xor < 1024; xor++) {
            if (canReach(grid, 0, 0, xor)) {
                minXor = Math.min(minXor, xor);
            }
        }
        return minXor;
    }

    private boolean canReach(int[][] grid, int i, int j, int targetXor) {
        if (i >= m || j >= n) return false;
        
        // If we reach the bottom-right cell
        if (i == m - 1 && j == n - 1) {
            return grid[i][j] == targetXor;
        }
        
        if (memo[i][j][targetXor] != null) {
            return memo[i][j][targetXor];
        }
        
        // Since we are working backwards or checking if targetXor is achievable:
        // A cell's value grid[i][j] must be part of the XOR chain.
        int nextXor = targetXor ^ grid[i][j];
        
        boolean res = canReach(grid, i + 1, j, nextXor) || canReach(grid, i, j + 1, nextXor);
        return memo[i][j][targetXor] = res;
    }
}