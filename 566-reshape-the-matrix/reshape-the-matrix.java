class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;

        if(r*c != n*m)   return mat;

        int[][] arr = new int[r][c];
        int x = 0 , y = 0;
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                arr[i][j] = mat[x][y];
                y++;
                if(y == m){
                    x++;
                    y=0;
                }
            }
        }
        return arr;
    }
}