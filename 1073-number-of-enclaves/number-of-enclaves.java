class Solution {
    int[] row = {-1 , 1 , 0 , 0};
    int[] col = {0 , 0 , -1 , 1};
    int n , m;
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(grid[i][j] == 1){
                        DFS(i , j , grid);
                    }
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public void DFS(int i , int j , int[][] grid){
        if(grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;

        for(int k = 0 ; k < 4 ; k++){
            int new_i = i + row[k];
            int new_j = j + col[k];

            if(valid(new_i , new_j)){
                DFS(new_i , new_j , grid);
            }
        }
    }
    public boolean valid(int i , int j){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}