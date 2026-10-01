class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int k = 1;
        int top = 0 , left = 0 , right = n-1 , bottom = n-1;
        while(k <= n*n){
            // 1. Move Right
            for(int i = left ; i <= right ; i++){
                matrix[top][i] = k;
                k++;
            }
            top++;

            // 2. Move Down
            for(int i = top ; i <= bottom ; i++){
                matrix[i][right] = k;
                k++;
            }
            right--;

            // 3. Move Left
            if(top <= bottom){
                for(int i = right ; i >= left ; i--){
                    matrix[bottom][i] = k;
                    k++;
                }
            }
            bottom--;

            // 4. Move Up
            if(left <= right){
                for(int i = bottom ; i >= top ; i--){
                    matrix[i][left] = k;
                    k++;
                }
            }
            left++;
        }
        return matrix;
    }
}