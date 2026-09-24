class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;

        return IntStream.range(0, nums.length)
                .filter(i -> digitSum(nums[i]) == i)
                .findFirst()
                .orElse(-1);
    }
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}