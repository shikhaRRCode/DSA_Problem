class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if(n <= 3){
            return 0;
        }

        Arrays.sort(nums);
        int firstTwoToThird = Math.abs(nums[2] - nums[n-1]);
        int lastTwoToLastThird = Math.abs(nums[n-3] - nums[0]);
        int firstAndLastToSecond = Math.abs(nums[1] - nums[n-2]);
 

        return Math.min(firstTwoToThird , Math.min(lastTwoToLastThird , firstAndLastToSecond));
    }
}