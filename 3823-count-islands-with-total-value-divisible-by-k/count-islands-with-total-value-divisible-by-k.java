class Solution {
    int[] row = {-1 , 0 , 1 , 0};
    int[] col = { 0 , 1 , 0 , -1};
    int m , n;
    long sum;
    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] > 0){
                    sum = 0;
                    dfs(grid , i , j);

                    if(sum % k == 0) count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid , int i , int j){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return;
        }
        if(grid[i][j] <= 0){
            return;
        }

        sum += grid[i][j];
        grid[i][j] = -1;
        for(int k = 0 ; k < 4 ; k++){
            int new_i = i + row[k];
            int new_j = j + col[k];

            dfs(grid , new_i , new_j);
        }
    }
}