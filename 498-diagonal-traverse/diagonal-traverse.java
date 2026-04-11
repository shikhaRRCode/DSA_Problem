class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] res = new int[n*m];
        int r = 0, c = 0 , dir = 1;  // 1 = up-right, -1 = down-left

        for(int i = 0 ; i < n*m ; i++){
            res[i] = mat[r][c];

            if(dir == 1){//going up
                if(c == m-1){
                    r++;
                    dir = -1;
                }
                else if(r == 0){
                    c++;
                    dir =-1;
                }
                else{
                    r--;
                    c++;
                }
            }
            else{  //going-down
                if(r == n-1){
                    c++;
                    dir = 1;
                }
                else if(c == 0){
                    r++;
                    dir = 1;
                }
                else{
                    r++;
                    c--;
                }
            }
        }

        return res;
    }
}