class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;

        int start = 0 , end = n-1;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;

            //left-side sorted
            if(nums[mid] >= nums[0]){
                start = mid+1;
            }
            else{
                //right side sorted
                ans = mid;
                end = mid-1;
            }
        }
        return nums[ans];
    }
}