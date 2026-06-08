class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int start = 1;
        int end = 0;
        for(int i = 0 ; i < n ; i++){
            end = Math.max(end , nums[i]);
        }

        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;

            int sum = 0;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] % mid != 0){
                    sum += nums[i]/mid + 1;
                }
                else{
                    sum += nums[i]/mid;
                }
            }
            if(sum <= threshold){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }

        }
        return ans;
    }
}