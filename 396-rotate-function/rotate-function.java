class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int f = 0;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum +=  nums[i];
            f += (i * nums[i]);
        }

        int result = f;
        for(int k = 0 ; k <= n-1 ; k++){
            int newF = f + sum - n * nums[n-1-k];
            result = Math.max(result , newF);

            f = newF;
        }
        return result;
    }
}