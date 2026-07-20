class Solution {
    int row , col;
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        row = grid.length;
        col = grid[0].length;
        k = k % (row*col);

        swap(grid , 0 , row*col -1);
        swap(grid , 0 , k-1);
        swap(grid , k , row*col - 1);

        List<List<Integer>> ans = new ArrayList<>();
        for(int[] row : grid){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int val : row){
                temp.add(val);
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;

    }
    public void swap(int[][] grid , int i , int j){
        while (i < j) {
            int temp = grid[i / col][i % col];
            grid[i / col][i % col] = grid[j / col][j % col];
            grid[j / col][j % col] = temp;
            i++;
            j--;
        }
    }
}
//[1 2 3]
//[4 5 6]
//[7 8 9]

//[9 1 2]
//[3 4 5]
//[6 7 8]

//[8 9 1]
//[2 3 4]
//[5 6 7]