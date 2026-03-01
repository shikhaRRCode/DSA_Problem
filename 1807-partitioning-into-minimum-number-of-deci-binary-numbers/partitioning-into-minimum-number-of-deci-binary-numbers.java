class Solution {
    public int minPartitions(String n) {
        // (The largest character will take time to reach 0)
        char maxCh = '0';
        for(char ch : n.toCharArray())
        {
            // compare current digit with maxCh and store the larger one
            maxCh = (char)Math.max(maxCh , ch);
        }
        // convert character digit to integer and return it
        return maxCh - '0';
    }
}