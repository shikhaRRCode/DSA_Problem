class Solution {
    int[] row = {-1,-1,-1,0,1,1,1,0};
    int[] col = {-1,0,1,1,1,0,-1,-1}; 
    int n,m;
    public void gameOfLife(int[][] board) {
        n = board.length;
        m = board[0].length;
        int[][] next = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int live = 0;

                for(int k = 0 ; k < 8 ; k++){
                    int ni = i + row[k];
                    int nj = j + col[k];

                    if(check(ni, nj) && board[ni][nj] == 1){
                        live++;
                    }
                }

                if(board[i][j] == 1){
                    if(live == 2 || live == 3){
                        next[i][j] = 1;
                    }else{
                        next[i][j] = 0;
                    }
                }else{
                    if(live == 3){
                        next[i][j] = 1;
                    }else{
                        next[i][j] = 0;
                    }
                }
        
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                board[i][j] = next[i][j]; 
            }
        }
    }
    public boolean check(int i , int j){
        return i >= 0 && i < n && j >= 0 && j < m;                           
    }
}
//logic: 
//dead -> neigh three = live
//live : neigh : 1 = dead
//     : neigh :2 or 3 = live
//     : 4 or more = dead
     