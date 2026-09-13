class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        int maxOverlap = 0;
        for(int row_off = -n+1 ; row_off <= n-1 ; row_off++){
            for(int col_off = -n+1 ; col_off <= n-1 ; col_off++){
                int count = countOverlaps(img1 , img2 , row_off , col_off);

                maxOverlap = Math.max(maxOverlap , count);
            }
        }
        return maxOverlap;
    }
    public int countOverlaps(int[][] A , int[][] B , int row_off , int col_off){
        int n = A.length;

        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                //find indices of B from A ka indicesint 
                int B_i = i + row_off;
                int B_j = j + col_off;

                if(B_i < 0 || B_j < 0 || B_i >= n || B_j >= n){
                    continue;
                }

                if(A[i][j] == 1 && B[B_i][B_j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}