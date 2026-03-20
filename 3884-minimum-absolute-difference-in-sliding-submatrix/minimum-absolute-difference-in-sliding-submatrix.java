class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n-k+1][m-k+1];

        for(int i = 0 ; i <= n-k ; i++)
        {
            for(int j = 0 ; j <= m-k ; j++)
            {
                // TreeSet for sorted + distinct elements
                TreeSet<Integer> vals = new TreeSet<>();

                for(int x = i ; x <= i + k -1; x++){
                    for(int y = j ; y <= j + k -1 ; y++){
                        vals.add(grid[x][y]);
                    }
                }

                if(vals.size() == 1){
                    ans[i][j] = 0;
                    continue;
                }
                int minAbsDiff = Integer.MAX_VALUE;

                Integer prev = null;
                for (int val : vals) {
                    if (prev != null) {
                        minAbsDiff = Math.min(minAbsDiff, val - prev);
                    }
                    prev = val;
                }

                ans[i][j] = minAbsDiff;
            }
        }
        return ans;
    }
}