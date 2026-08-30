class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = nums[0] , min_idx = 0;
        int max = nums[0] , max_idx = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < min){
                min = nums[i];
                min_idx = i;
            }
            if(nums[i] > max){
                max = nums[i];
                max_idx = i;
            }
        }

        int left_idx = Math.min(min_idx , max_idx);
        int right_idx = Math.max(min_idx ,max_idx);

        // Option 1: Both from front
        int option1 = right_idx + 1;
        // Option 2: Both from back
        int option2 = n - left_idx;
        // Option 3: One from front, one from back
        int option3 = (left_idx + 1) + (n - right_idx);
        
        return Math.min(option1, Math.min(option2, option3));
    }
}