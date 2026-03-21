class Solution {
    public int rob(int[] nums) 
    {
        int n = nums.length;
        //Recursion + Memoization

        //1. Create dp array  
        int[] dp = new int[n+1];
        Arrays.fill(dp , -1);

        return solve(0 , nums , dp);
    }
    public int solve(int i , int[] nums , int[] dp)
    {
        if(i >= nums.length){
            return 0;
        }
        
        //2. Check
        if(dp[i] != -1){
            return dp[i];
        }

        //steal
        int pick = nums[i] + solve(i + 2  , nums , dp);
        //skip
        int nPick = solve(i+1 , nums , dp);

        //3. Store
        dp[i] = Math.max(pick , nPick);
        return dp[i];
    }

}