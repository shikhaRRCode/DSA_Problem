class Solution {
    public boolean canAliceWin(int n) {
        boolean turn = false;  //pehli turn alice ki , therefore alice on the verge of losing
        int stonesToRemove = 10;    

        while(n >= stonesToRemove){
            n -= stonesToRemove;
            stonesToRemove--;
            turn = !turn;
        }
        return turn;
    }
}