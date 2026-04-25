class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans=0 , diff=Integer.MAX_VALUE;
        // fix first element
        for(int i = 0 ; i < n - 2 ; i++){
            int st = i+1, end = n-1;
            // find best pair for nums[i]
            while(st < end){
                int sum = nums[i]+nums[st]+nums[end];

                // if exact match → return immediately
                if(sum == target){
                    return sum;
                }

                // update answer if this sum is closer to target
                if(Math.abs(target - sum) < diff){
                    ans = sum;
                    diff = Math.abs(target-sum);
                    
                }

                // move pointers
                if(sum < target)  st++;

                else   end--;
            }
        }
        return ans;   
    }
}