class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        // result matrix for each k x k submatrix
        int[][] ans = new int[n-k+1][m-k+1];

        // iterate over all possible k x k submatrices
        for(int i = 0 ; i <= n-k ; i++){
            for(int j = 0 ; j <= m-k ; j++){
                
                // TreeSet for sorted + distinct elements
                TreeSet<Integer> vals = new TreeSet<>();

                // collect all elements of current k x k submatrix
                for(int x = i ; x <= i + k -1; x++){
                    for(int y = j ; y <= j + k -1 ; y++){
                        vals.add(grid[x][y]);
                    }
                }

                // if all elements are same → min difference = 0
                if(vals.size() == 1){
                    ans[i][j] = 0;
                    continue;
                }
                int minAbsDiff = Integer.MAX_VALUE;

                // check difference between adjacent sorted elements
                Integer prev = null;
                for (int val : vals) {
                    if (prev != null) {
                        minAbsDiff = Math.min(minAbsDiff, val - prev);
                    }
                    prev = val;
                }

                // store result for this submatrix
                ans[i][j] = minAbsDiff;
            }
        }
        return ans;
    }//T.C : O(O((m−k)×(n−k)×k^2×logk)
}    //S.C : O(k^2)