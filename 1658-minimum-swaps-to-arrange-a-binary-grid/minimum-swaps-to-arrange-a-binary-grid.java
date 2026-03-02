class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;

        int[] endZeroes = new int[n];
        //1.Find endZeroes[i] = no. of consecutive zeroes at end
        for(int i = 0 ; i < n ; i++)
        {
            int count = 0;
            int j = n-1;      //start from end
            while( j >=0 && grid[i][j] == 0){
                count++;
                j--;
            }
            endZeroes[i] = count;
        }
        //2.For each row
        int steps = 0;
        for(int i = 0 ; i < n ; i++)
        {
            //  -->check need of zeroes (n-i-1)
            int need = n - i - 1;

            int j=i;
            //  -->Check the nearest row having 0's >= need
            while( j < n && endZeroes[j] < need){
                j++;
            }

            //3. If not found return -1
            //  else swapSteps = (j-i);
            if(j == n){
                return -1;
            }
            steps += j - i;
            while(j > i){
                swap(endZeroes, j , j-1);
                j--;
            }
        }

        return steps;
    }
    public void swap(int[] arr , int i , int j)
    {
        //swaping
        arr[i] = arr[i] + arr[j] - (arr[j] = arr[i]);
    }
}