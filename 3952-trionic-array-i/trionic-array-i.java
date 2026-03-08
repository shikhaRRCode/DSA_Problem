class Solution {
    public boolean isTrionic(int[] nums) 
    {
        int n = nums.length;
        int count = 0;
        for(int i = 0  ; i < n-1 ; i++){
            if(count % 2 == 0 && nums[i] < nums[i+1]){
                count++;
                while(i < n-1 && nums[i] < nums[i+1]){
                    i++;
                }
                i--;
            }
            else if(count % 2 == 1 && nums[i] > nums[i+1]){
                count++;
                while(i < n-1 && nums[i] > nums[i+1]){
                    i++;
                }
                i--;
            }
            else{
                return false;
            }
        } 
        return count == 3;   
    }
}