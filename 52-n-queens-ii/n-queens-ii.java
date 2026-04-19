class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        List<String> board = new ArrayList<>();

        //Initializing board [ "...." , "...." , "...." , "...."]
        for(int i = 0 ; i < n ; i++)
        {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while(j < n)
            {
                sb.append(".");
                j++;
            }
            board.add(sb.toString());
        }   

        boolean[] col = new boolean[n];      //to track column
        boolean[] leftDiagonal = new boolean[2*n-1];    //to track left diagonal
        boolean[] rightDiagonal = new boolean[2*n-1];   //to track right diagonal

        find(0 , n , board , col , leftDiagonal , rightDiagonal);

        return count;
    }
    public void find(int row , int n , List<String> board , boolean[] col , boolean[] leftDiagonal, boolean[] rightDiagonal)
    {
        //base condition(if all rows filled, add solution)
        if(row == n)
        {
            count++;
            return;
        }

        // try placing queen in each column
        for(int j = 0 ; j < n ; j++)
        {
            //checking diagonal and column
            //left diagonal : subtract
            //right diagonal : add
            if(!col[j] && !rightDiagonal[row+j] && !leftDiagonal[j-row + (n-1)])
            {
                col[j] = true;                                           //mark column
                rightDiagonal[row+j] = true;                                //mark leftdiagonal
                leftDiagonal[j-row + (n-1)] = true;                       //mark rightdiagonal
                StringBuilder sb = new StringBuilder(board.get(row));
                sb.setCharAt(j , 'Q');                                    // place queen
                board.set(row , sb.toString());

                find(row+1 , n , board , col , leftDiagonal , rightDiagonal);    //recursive call

                //backtrack
                col[j] = false;
                rightDiagonal[row+j] = false;
                leftDiagonal[j-row + (n-1)] = false;
                sb = new StringBuilder(board.get(row));
                sb.setCharAt(j , '.');
                board.set(row , sb.toString());
            }
        }
    }
}