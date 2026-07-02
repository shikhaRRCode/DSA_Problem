class Solution {
    int[][] dp; // Stores the maximum health found at cell (i, j)
    int n, m;
    int row[] = {0, 0, -1, 1};
    int col[] = {-1, 1, 0, 0};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        n = grid.size();
        m = grid.get(0).size();
        
        // Initialize DP array with -1 (meaning unvisited)
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        // Deduct the starting cell's cost immediately
        return solve(0, 0, grid, health - grid.get(0).get(0));
    }

    public boolean solve(int i, int j, List<List<Integer>> grid, int health) {
        // If health drops below 1, this path is dead
        if (health < 1) return false;
        
        // Reached destination successfully
        if (i == n - 1 && j == m - 1) return true;

        // If we've been here before with a better or equal health, cut recursion short
        if (dp[i][j] >= health) return false;
        
        // Record the highest health we've managed to bring to this cell
        dp[i][j] = health;

        for (int k = 0; k < 4; k++) {
            int new_i = row[k] + i;
            int new_j = col[k] + j;

            if (check(new_i, new_j)) {
                int val = grid.get(new_i).get(new_j);
                
                // Early pruning if the next step would kill us
                if (health - val < 1) {
                    continue; 
                }
                
                if (solve(new_i, new_j, grid, health - val)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}