class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;

        int minElement = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            int curr = nums[i];
            int sum = 0;
            while(curr > 0){
                int rem = curr % 10;
                sum = sum + rem;
                curr/=10;
            }
            minElement = Math.min(minElement , sum);
        }   
        return minElement;
    }
}