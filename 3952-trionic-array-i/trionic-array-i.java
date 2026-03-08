class Solution {
    public boolean isTrionic(int[] nums) 
    {
        int n = nums.length;
        int count = 0;
        for(int i = 0  ; i < n-1 ; i++){
            // even count → expect increasing phase
            if(count % 2 == 0 && nums[i] < nums[i+1]){
                count++;
                while(i < n-1 && nums[i] < nums[i+1]){
                    i++;
                }
                i--;          // adjust index because for-loop will increment
            }
            // odd count → expect decreasing phase
            else if(count % 2 == 1 && nums[i] > nums[i+1]){
                count++;
                while(i < n-1 && nums[i] > nums[i+1]){
                    i++;
                }
                i--;
            }
            // if pattern breaks, array is not trionic
            else{
                return false;
            }
        } 
        // valid only if we saw exactly 3 phases: increase → decrease → increase
        return count == 3;   
    }
}