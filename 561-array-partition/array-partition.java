class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; i+=2){
            int j = i+1;
            sum += Math.min(nums[i] , nums[j]);
        }

        return sum;

    }
}