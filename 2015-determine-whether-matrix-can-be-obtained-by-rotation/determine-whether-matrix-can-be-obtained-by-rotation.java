class Solution {
    public boolean findRotation(int[][] mat, int[][] target) 
    {
        int n = mat.length;

        boolean flag;
        //maximum 4 rotations(360 degree)
        for(int k = 1 ; k <= 4 ; k++)
        {
            flag = true;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(mat[i][j] != target[i][j]){
                        flag = false;
                        break;
                    }
                }
            }

            //if mat == target
            if(flag == true){
                return true;
            }
            else{
                rotate(mat , n);
            }
        }    
        return false;
    }
    public void rotate(int[][] mat , int n){
        //To rotate by 90 degree : 2 steps
        //1. Transpose
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        //2. reverse each row
        for(int i = 0 ; i < n ; i++){
            int start = 0 , end = n-1;
            while(start < end){
                mat[i][start] =mat[i][start] + mat[i][end] - (mat[i][end] = mat[i][start]);

                start++;end--;
            }
        }

    }
}