class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minSuff = new int[n]; 
        minSuff[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            minSuff[i] = Math.min(minSuff[i+1] , nums[i]);
        }

        int max = nums[0];
        for(int i = 0 ; i < n ; i++){
            max = Math.max(nums[i] , max);
            int score = max - minSuff[i];
            if(score <= k){
                return i;
            }
        }
        return -1;
    }
}