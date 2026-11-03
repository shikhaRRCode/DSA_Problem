class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int max = 0 , sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(max < nums[i]){
                max = nums[i];
            }

            sum+=nums[i];
        }

        return Math.abs(sum - (n*max));
    }
}