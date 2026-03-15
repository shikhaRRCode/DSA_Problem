class Solution {
    // memoization array to store result of each index
    int[] t = new int[10001];

    public boolean canJump(int[] nums) {
        int n = nums.length;

        // initialize memo with -1 (not computed yet)
        Arrays.fill(t , -1);

        return solve(nums , n , 0);
    }
    public boolean solve(int[] nums , int n , int idx)
    {
        // if we reach last index → jump is possible
        if(idx == n-1){
            return true;
        }

        // if already solved before, return stored result
        if(t[idx] != -1){
            return t[idx] == 0 ? false : true;
        }

        // try all possible jumps from current index
        for(int i = 1 ; i <= nums[idx] ; i++){
            if(solve(nums , n , idx + i)){
                t[idx] = 1;    // store true
                return true;
            }
        }
        // if no jump works, mark this index as false
        t[idx] = 0;
        return false;
    }
}                                       