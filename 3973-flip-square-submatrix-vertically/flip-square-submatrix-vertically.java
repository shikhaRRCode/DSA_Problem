class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int srtRow = x, endRow = x + k -1;
        int srtCol = y , endCol = y + k -1;

        for(int i = srtRow ; i <= endRow ; i++){
            for(int j = srtCol ; j <= endCol ; j++){
                int temp = grid[i][j];
                grid[i][j] = grid[endRow][j];
                grid[endRow][j] = temp;
            }
            endRow--;
        } 
        return grid;
    }
}