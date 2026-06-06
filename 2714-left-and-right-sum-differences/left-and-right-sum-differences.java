class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        
        int lsum[]=new int[n];
        int rsum[]=new int[n];
        lsum[0]=0;
        rsum[n-1]=0;

        for(int i=1;i<n;i++)
        {
            lsum[i]=nums[i-1]+lsum[i-1];
        }
        for(int i=n-2;i>=0;i--)
        {
            rsum[i]=nums[i+1]+rsum[i+1];
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=Math.abs(rsum[i]-lsum[i]);
        }
        return ans;
    }
}