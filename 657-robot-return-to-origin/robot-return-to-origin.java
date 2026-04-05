class Solution {
    public boolean judgeCircle(String moves) 
    {
        int Up = 0 , Down = 0 , Left = 0 , Right = 0;
        for(int i = 0 ; i < moves.length() ; i++){
            char ch = moves.charAt(i);
            if(ch == 'U'){
                Up++;
            }
            if(ch == 'D'){
                Down++;
            }
            if(ch == 'L'){
                Left++;
            }
            if(ch == 'R'){
                Right++;
            }
        }    

        return Left == Right && Up == Down;
    }
}