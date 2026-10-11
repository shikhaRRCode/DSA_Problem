class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;

        int squaredSum = 0;
        for(int i = 0 ; i < n ; i++){
            if(n % (i+1) == 0){  // nums[i] is special
                squaredSum += nums[i]*nums[i];
            }
        }
        return squaredSum;
    }
}