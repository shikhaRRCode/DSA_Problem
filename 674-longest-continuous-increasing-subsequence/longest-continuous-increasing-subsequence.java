class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;

        int maxLen = 1 , len = 1;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] <= nums[i-1]){
                maxLen = Math.max(len , maxLen);
                len = 0;
            }
            len++;
        }
        maxLen = Math.max(len , maxLen);

        return maxLen;
    }
}