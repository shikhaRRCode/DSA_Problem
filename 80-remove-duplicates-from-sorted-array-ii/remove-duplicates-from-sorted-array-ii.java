class Solution {
    public int removeDuplicates(int[] nums) 
    {
        int n = nums.length;
        if(n <= 2) return n;

        int unique2 = 2;

        for(int i = 2 ; i < n ; i++)
        {
            if(nums[i] != nums[unique2 - 2])
            {
                nums[unique2] = nums[i];
                unique2++;
            }
        }

        return unique2;
    }
}