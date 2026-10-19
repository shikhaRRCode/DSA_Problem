class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);
        List<Integer> ans = IntStream.range(0, nums.length)
                .filter(i -> nums[i] == target)
                .boxed()
                .collect(Collectors.toList());
        return ans;
    }
}