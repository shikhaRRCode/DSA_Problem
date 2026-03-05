class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(n == 1)  return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;

        int start = 1 , end = n-2;
        int mid;
        while(start <= end){
            mid = (start + end)/2;

            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid+1]){
                return mid;
            }
            else if(nums[mid] < nums[mid - 1]){
                end = mid-1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
}