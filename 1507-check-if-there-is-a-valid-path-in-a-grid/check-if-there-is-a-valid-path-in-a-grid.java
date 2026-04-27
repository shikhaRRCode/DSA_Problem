class Solution {
    int[][][] directions = { 
        {  {}    ,  {}   },
        { {0,-1} , {0,1} },
        { {-1,0} , {1,0} },
        { {0,-1} , {1,0} },
        { {1,0}  , {0,1} },
        { {0,-1} , {-1,0} },
        { {-1,0} , {0,1} }
        };
    int n , m;    
    public boolean hasValidPath(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        return DFS(0 , 0 , -1 , -1 , grid , visited);
    }
    public boolean DFS(int i , int j , int prev_i , int prev_j ,  int[][] grid , boolean[][] visited){
        if(i == n-1 && j == m-1){
            return true;
        }

        visited[i][j] = true;

        for(int[] dir : directions[ grid[i][j] ]){
            int x = i + dir[0];
            int y = j + dir[1];

            if(valid(x , y ) && !visited[x][y]  && (x != prev_i || y != prev_j)){
                boolean goBack = check(x , y , i , j , directions[grid[x][y]]);

                if(goBack){
                    if(DFS(x , y , i , j , grid , visited)){
                        return true;
                    }
                }

            }
        }
        return false;
    }
    public boolean valid(int i , int j){
        return i >= 0 && i < n && j >= 0 && j < m;
    }
    public boolean check(int x , int y , int i , int j , int[][] d){
        for(int[] dir : d){
            int new_i =x + dir[0];
            int new_j =y + dir[1];

            if(new_i == i && new_j == j){
                return true;
            }
        }
        return false;

    }
}