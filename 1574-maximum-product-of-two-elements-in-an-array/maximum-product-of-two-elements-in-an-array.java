class Solution {
    public int maxProduct(int[] nums) 
    {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;  

        int maxidx = 0;
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] > max)
            {
                max = nums[i];
                maxidx = i;
            }
        }  
        for(int i = 0 ; i < n ; i++)
        {
            if(nums[i] > smax && i != maxidx)
            {
                smax = nums[i];
            }
        } 

        return (max - 1) * (smax - 1);
    }
}