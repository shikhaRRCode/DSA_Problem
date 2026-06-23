class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int start = 0 , end = n-1;
        while(start <= end){
            int mid = (start + end)/2;

            if(nums[mid] == target){
                return true;
            }

            // Edge case: when duplicates make it impossible to determine the sorted half
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            //left-side sorted
            if(nums[mid] >= nums[start]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }

            //right-side sorted
            else{
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}