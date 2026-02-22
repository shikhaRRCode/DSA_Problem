class Solution {
    public int binaryGap(int n) {
        int ans = 0;
        int prevbit = -1;
        int currbit = 0;
        while(n > 0)
        {
            if(n%2 == 1){
                if(prevbit != -1)
                {
                    ans = Math.max(ans , currbit - prevbit);
                }
                prevbit = currbit;
            }
            currbit++;
            n = n >> 1;    //Right Shift
        }
        return ans;
    }
}