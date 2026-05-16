class Solution {
    int ans;
    public int findMin(int[] nums) {
        int n = nums.length;
        int ans = nums[0];

        for(int i = 1 ; i < n ; i++){
            if(nums[i] < ans){
                ans = nums[i];
            }
        }
        return ans;
    }

}