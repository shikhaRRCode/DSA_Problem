class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        // If count of stones with remainder 0 is even, 
        // the presence of 0s doesn't change the outcome/turn parity.
        if (count[0] % 2 == 0) {
            return count[1] >= 1 && count[2] >= 1;
        }
        
        // If count of stones with remainder 0 is odd, 
        // 0s flip the parity of turns, so Alice needs a difference >= 3.
        return Math.abs(count[1] - count[2]) >= 3;
    }
}