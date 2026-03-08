class Solution {
    public int[] constructTransformedArray(int[] nums) 
    {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            //Normalize -ve index : (i + nums[i]) % n
            res[i] = nums[((i + nums[i]) % n + n) % n];
        }    
        return res;
    }
}