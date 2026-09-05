class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minSuffix = new int[n];
        minSuffix[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            minSuffix[i] = Math.min(minSuffix[i+1] , nums[i]);
        }

        int score = Integer.MAX_VALUE;
        int max = nums[0];
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , nums[i]);
            score = max - minSuffix[i];
            if(score <= k){
                return i;
            }
        } 

        return -1;
    }
}