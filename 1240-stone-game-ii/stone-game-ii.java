class Solution {
    int n;
    int[][][] t = new int[2][101][101];
    public int stoneGameII(int[] piles) {
        n = piles.length;

        return solveForAlice(1 , 0 , 1 , piles);   //1 -> Alice , 0 -> Bob
        
    }
    public int solveForAlice(int person , int i , int M , int[] piles){
        if(i >= n){
            return 0;
        }

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;
        for(int x = 1 ; x <= Math.min(2*M , n-i) ; x++){
            stones += piles[i+x-1];

            if(t[person][i][M] != 0){
                return t[person][i][M];
            }
            
            if(person == 1){     //Alice
                result = Math.max(result , stones + solveForAlice(0 , i+x , Math.max(x , M) , piles));
            }
            else if(person == 0){  //Bob
                result = Math.min(result , solveForAlice(1 , i+x , Math.max(x , M) , piles));
            }
        }
        return t[person][i][M] = result;
    }
}
//Game thory : If it's your turn do your Best   (Math.max)
//             If it's your opponent's turn expect the worst   (Math.min)