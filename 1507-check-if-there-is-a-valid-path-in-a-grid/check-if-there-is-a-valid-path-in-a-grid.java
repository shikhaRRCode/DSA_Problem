class Solution {
    // directions for each street type
    int[][][] directions = { 
        {  {}    ,  {}   },      
        { {0,-1} , {0,1} },           //1 : left , right
        { {-1,0} , {1,0} },           //2 : up   , down
        { {0,-1} , {1,0} },           //3 : left , down
        { {1,0}  , {0,1} },           //4 : down , right
        { {0,-1} , {-1,0} },          //5 : left , up
        { {-1,0} , {0,1} }            //6 : up   , right
        };
    int n , m;    
    public boolean hasValidPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        return DFS(0 , 0 , grid , visited);
    }
    public boolean DFS(int i , int j ,  int[][] grid , boolean[][] visited){
        // if reached end → path found
        if(i == n-1 && j == m-1){
            return true;
        }

        visited[i][j] = true;

        // try all allowed directions of current cell
        for(int[] dir : directions[ grid[i][j] ]){
            int x = i + dir[0];
            int y = j + dir[1];

            if(valid(x , y ) && !visited[x][y]){
                // check if next cell connects back
                boolean goBack = check(x , y , i , j , directions[grid[x][y]]);

                // if connection valid → move forward
                if(goBack){
                    if(DFS(x , y , grid , visited)){
                        return true;         //path found
                    }
                }

            }
        }
        return false;
    }
    // check boundaries
    public boolean valid(int i , int j){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    // check if next cell connects back to current cell
    public boolean check(int x , int y , int i , int j , int[][] d){
        for(int[] dir : d){
            int new_i =x + dir[0];
            int new_j =y + dir[1];

            // if it can come back → valid connection
            if(new_i == i && new_j == j){
                return true;
            }
        }
        return false;

    }
}