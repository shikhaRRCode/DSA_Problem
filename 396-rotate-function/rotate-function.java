class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int f = 0;
        int sum = 0;
        // calculate total sum and F(0)
        // F(0) = 0*nums[0] + 1*nums[1] + ... + (n-1)*nums[n-1]
        for(int i = 0 ; i < n ; i++){
            sum +=  nums[i];
            f += (i * nums[i]);
        }

        int result = f;
        // use relation to compute next rotations
        // F(k+1) = F(k) + sum - n * last_element_of_previous_rotation
        for(int k = 0 ; k <= n-1 ; k++){
            // compute next rotation value using formula
            int newF = f + sum - n * nums[n-1-k];

            // update maximum
            result = Math.max(result , newF);

            //move to next rotation
            f = newF;
        }
        return result;
    }
}