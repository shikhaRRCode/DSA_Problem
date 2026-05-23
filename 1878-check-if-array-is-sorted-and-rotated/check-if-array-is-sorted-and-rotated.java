class Solution {
    public boolean check(int[] nums) 
    {
        int count = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {

            // compare current with next (circularly)
            if(nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // valid only if decreasing point <= 1
        return count <= 1;
    }
}