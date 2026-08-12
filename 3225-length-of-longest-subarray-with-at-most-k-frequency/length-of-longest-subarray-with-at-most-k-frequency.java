class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int left = 0;
        int longestSub_arrayLength = 0;
        for (int right = 0; right < n; right++) {
            // Always add the current element to the map
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // If frequency exceeds k, shrink the window from the left
            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            // Update the maximum subarray length
            longestSub_arrayLength = Math.max(longestSub_arrayLength, right - left + 1);
        }
        return longestSub_arrayLength;
    }
}