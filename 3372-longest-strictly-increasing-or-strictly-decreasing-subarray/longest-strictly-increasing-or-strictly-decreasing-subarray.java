class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int left = 0;
        int ans = 1;
        int increasing = 1 , decreasing = 1;
        for(int right = 1 ; right < n ; right++){
            if(nums[right] > nums[right-1]){
                increasing++;
            }
            else{
                ans = Math.max(ans , increasing);
                increasing = 1;
            }

            if(nums[right] < nums[right-1]){
                decreasing++;
            }
            else{
                ans = Math.max(ans , decreasing);
                decreasing = 1;
            }
        }
        ans = Math.max(ans , Math.max(increasing , decreasing));
        return ans;
    }
}