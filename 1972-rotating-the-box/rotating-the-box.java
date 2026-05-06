class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char[][] rotBox = new char[n][m];
        //1. Transpose matrix
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                rotBox[i][j] = boxGrid[j][i];
            }
        }

        //2.  Reverse each row of transposed matrix
        for(char[] row : rotBox){
            int i = 0 , j = m-1;
            while(i < j){
                char temp = row[i];
                row[i] = row[j];
                row[j] = temp;

                i++;j--;
            }
        }

        //3. Apply gravity
        for(int col = 0 ; col < m ; col++){
            int space = n-1;
            for(int row = n-1 ; row >= 0 ; row--){
                if(rotBox[row][col] == '*'){
                    space = row-1;
                }
                else if(rotBox[row][col] == '#'){
                    rotBox[row][col] = '.';
                    rotBox[space][col] = '#';
                    space--;
                }
            }
        }

        return rotBox;
    }
}