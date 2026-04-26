class Solution {
    // directions: up, down, left, right
    int[] row = {-1 , 1 , 0 , 0};
    int[] col = {0 , 0 , -1 , 1};
    int n , m;
    public boolean containsCycle(char[][] grid) 
    {
        n = grid.length;
        m = grid[0].length;
        // track visited cells
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                // start DFS if not visited
                if(!visited[i][j] && DFS(grid , visited ,  i , j , -1 , -1)){
                    return true;
                }    
            }
        }
        return false;   // no cycle
    }
    public boolean DFS(char[][] grid ,boolean[][] visited ,  int i , int j , int prev_i , int prev_j){
        // if already visited → cycle
        if(visited[i][j]){
            return true;
        }

        //mark visited
        visited[i][j] = true;

        //checking neighbours
        for(int k = 0 ; k < 4 ; k++){
            int new_i = i + row[k];
            int new_j = j + col[k];

            // check valid, not parent, and same character
            if(valid(new_i , new_j) && (new_i != prev_i || new_j != prev_j) && grid[new_i][new_j] == grid[i][j]){
                if(DFS(grid , visited , new_i , new_j , i , j)){
                    return true;         //cycle detected
                }
            }
        }
        return false;           // no cycle from this path
    }
    public boolean valid(int i , int j ){
        return i >= 0 && i < n && j >=0 && j < m;
    }
}