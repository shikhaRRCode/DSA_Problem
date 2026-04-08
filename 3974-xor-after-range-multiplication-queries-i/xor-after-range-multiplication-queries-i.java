class Solution {
    int mod = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) 
    {
        int n = nums.length;
        int q = queries.length;

        for(int i = 0 ; i < q ; i++){
            for(int k = queries[i][0] ; k <= queries[i][1] ; k+=queries[i][2]){
                nums[k] = (int)((1L * nums[k]*queries[i][3]) % mod);
            } 
        }

        int xor = 0;
        for(int i = 0 ; i < n ; i++){
            xor^=nums[i];
        }
        return xor;
    }
}