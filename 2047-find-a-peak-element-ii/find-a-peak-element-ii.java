class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int start = 0 , end = m-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int rowIdx = maxElement(mat , mid , n , m);

            int left = mid-1 >= 0 ? mat[rowIdx][mid-1] : -1;
            int right = mid+1 < m ? mat[rowIdx][mid+1] : -1;

            if(mat[rowIdx][mid] > left && mat[rowIdx][mid] > right){
                return new int[]{rowIdx,mid};
            }
            else if(mat[rowIdx][mid] < left){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    public int maxElement(int[][] mat , int mid , int n , int m){
        int maxEle = 0 , rowIdx = -1;
        for(int i = 0 ; i < n ; i++){
            if(mat[i][mid] > maxEle){
                maxEle = mat[i][mid];
                rowIdx = i;
            }
        }
        return rowIdx;
    }
}