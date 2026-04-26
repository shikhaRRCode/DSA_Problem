class Solution {
    int[] row = {-1 , 1 , 0 , 0};
    int[] col = {0 , 0 , -1 , 1};
    int n , m;
    public boolean containsCycle(char[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && DFS(grid , visited ,  i , j , -1 , -1)){
                    return true;
                }    
            }
        }
        return false;
    }
    public boolean DFS(char[][] grid ,boolean[][] visited ,  int i , int j , int prev_i , int prev_j){
        if(visited[i][j]){
            return true;
        }

        visited[i][j] = true;

        for(int k = 0 ; k < 4 ; k++){
            int new_i = i + row[k];
            int new_j = j + col[k];

            if(valid(new_i , new_j) && (new_i != prev_i || new_j != prev_j) && grid[new_i][new_j] == grid[i][j]){
                if(DFS(grid , visited , new_i , new_j , i , j)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean valid(int i , int j ){
        return i >= 0 && i < n && j >=0 && j < m;
    }
}