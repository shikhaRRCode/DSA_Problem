class Solution {
    public boolean canJump(int[] nums) {
        //Greedy Approach --> Better than Dp for this question
        int n = nums.length;

        int maxReachable = 0;            // farthest index reachable so far
        for(int i = 0 ; i < n ; i++)
        {
            // if current index is beyond reachable range → we are stuck
            if(i > maxReachable){
                return false;
            }
            maxReachable = Math.max(maxReachable , i + nums[i]);
        }
        return true;                          //T.C = O(n)
    }
}                                       