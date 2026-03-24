class Solution {
    public int[][] constructProductMatrix(int[][] grid) 
    {
        int mod = 12345;
        int n = grid.length;
        int m = grid[0].length;

        long sfx = 1;
        int[][] p = new int[n][m];
        //calculating suffix product for 2-d matrix
        for(int i = n-1  ; i >= 0 ; i--)
        {
            for(int j = m-1 ; j >= 0 ; j--)
            {
                p[i][j] = (int)sfx;
                sfx = (sfx * grid[i][j]) % mod;
            }
        }

        //calculating prefix product on the flow
        //And storing int p[i][j] = suffix product * prefix product
        long pfx = 1;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                p[i][j] = (int)(pfx * p[i][j])%mod;
                pfx = (pfx * grid[i][j]) % mod;
            }
        }

        return p;
    }
}
