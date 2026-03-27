class Solution {
    int[] row = {-1 , 1 , 0 , 0};
    int[] col = {0 , 0 , -1 , 1};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(board[i][j] == word.charAt(0)  && solve(i , j , board , 0 , word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean solve(int i , int j , char[][] board , int idx , String word){
        // check current character
        if(board[i][j] != word.charAt(idx)){
            return false;
        }

        //Base case:
        if(idx == word.length()-1){
            return true;
        }

        char temp = board[i][j];
        board[i][j] = '$';         //Mark visited
        for(int k = 0 ; k < 4 ; k++){
            if(isValid(i + row[k] , j + col[k] , board) && board[i + row[k] ][j + col[k] ] != '$'){

                if(solve(i+row[k] , j+col[k] , board , idx+1 , word)){
                    return true;
                }

            }
        }
        board[i][j] = temp; //backtrack
        return false;    
    }
    public boolean isValid(int i , int j , char[][] board){
        return i>=0 && j>=0 && i < board.length && j < board[0].length;
    }
}