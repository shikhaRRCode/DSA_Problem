class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , -1);
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            map.put(sum , i);
        }

        int target = sum - x;
        int longestSubArray = -1;
        sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];

            if(map.containsKey(sum - target)){
                longestSubArray = Math.max(longestSubArray , i - map.get(sum-target));
            }
        }
        return longestSubArray == -1 ? -1 : n - longestSubArray;
    }
}