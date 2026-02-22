class Solution {
    public int binaryGap(int n) {
        int ans = 0;
        int prevbit = -1;
        int currbit = 0;
        while(n > 0)
        {
            // Check if current bit is 1
            if(n%2 == 1){
                // If we have seen a previous 1 before
                if(prevbit != -1)
                {
                    ans = Math.max(ans , currbit - prevbit);
                }
                // Update previous 1 position to current position
                prevbit = currbit;
            }
            currbit++;
            n = n >> 1;    // Right shift n (removes last bit)
        }
        return ans;
    }
}