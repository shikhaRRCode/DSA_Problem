class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;

        int k = -1;   //'1111111111' (aa bits set)
        for(int i = 0 ; i < n ; i++){
            if(nums[i] != i){
                k = (nums[i] & k);
            }
        }

        return k == -1 ? 0 : k;
    }
}