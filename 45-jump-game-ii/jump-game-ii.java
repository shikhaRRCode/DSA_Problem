class Solution {
    public int jump(int[] nums) 
    {
        int jumps = 0;     // number of jumps taken
        int range = 0;     // current range we can reach with current jumps
        int farthest = 0;  // farthest index we can reach

        // traverse array (no need to go till last index)
        for (int i = 0; i < nums.length - 1; i++) {

            // update farthest we can reach from current position
            farthest = Math.max(farthest, i + nums[i]);

            // if we reach end of current range → we must jump
            if (i == range) {
                jumps++;           // take jump
                range = farthest;  // update new range
            }
        }  
        return jumps;  
    }
}