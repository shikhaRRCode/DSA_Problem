class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        k = k%n;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int curr = j;
                int future;
                //Even row 
                if(i%2 == 0){
                    // left shift
                    future = (j + k)%n;
                }
                //oddd row
                else{
                    // right shift
                    future = (j + k + n)%n;
                }

                if(mat[i][curr] != mat[i][future]){
                    return false;
                }
            }
        }
        return true;
    }
}