class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int st = 0 , end = n-1;
        int ans = nums[0];
        while(st <= end){
            while(st < end && nums[st] == nums[st+1]){
                st++;
            }

            while(end > st && nums[end] == nums[end-1]){
                end--;
            }

            int mid = st + (end-st)/2;
            
            //left-side sorted
            if(nums[mid] >= nums[0]){
                st = mid+1;
            }
            else{
                //right side sorted
                ans = nums[mid];
                end = mid-1;
            }
        }
        return ans;
    }
}