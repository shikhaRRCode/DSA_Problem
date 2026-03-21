class Solution {
    public int rob(int[] nums) 
    {
        //Bottom-Up approach
        int n = nums.length;
        int[] dp = new int[n+1];

        // 0 houses → 0 money
        dp[0] = 0;
        // only 1 house → rob it
        dp[1] = nums[0];

        for(int i = 2 ; i <=n ; i++)
        {
            int steal = nums[i-1] + dp[i-2];
            int skip = dp[i-1];

            dp[i] = Math.max(steal , skip);
        }  

        return dp[n];
    }//dp[i] : represents max money stolen till house i
}    //here , we are counting from 1 , but array follows 0-based indexing that's why n+1