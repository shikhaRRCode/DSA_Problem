class Solution {
    public int numSpecial(int[][] mat) 
    {
        int m = mat.length;
        int n = mat[0].length;   

        int[] row = new int[m];
        int[] col = new int[n];
        // Step 1: Count number of 1's in every row and column
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(mat[i][j] == 1){
                    row[i] = row[i] + 1;
                    col[j] = col[j] + 1;
                }
            }
        }  

        int special = 0;
        // Step 2: Check for special positions
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    special++;
                }
            }
        } 
        return special;
    }
}