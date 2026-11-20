class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        // dp maps a value v -> max length of consecutive sequence ending at v
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            // Update num + 1 first so we don't accidentally chain the same element twice
            // (i.e., using `num` to extend a sequence and then `num + 1` extending from that same `num`)
            int lenPlusOne = dp.getOrDefault(num, 0) + 1;
            int lenCurrent = dp.getOrDefault(num - 1, 0) + 1;

            dp.put(num + 1, Math.max(dp.getOrDefault(num + 1, 0), lenPlusOne));
            dp.put(num, Math.max(dp.getOrDefault(num, 0), lenCurrent));

            maxLen = Math.max(maxLen, Math.max(dp.get(num), dp.get(num + 1)));
        }

        return maxLen;
    }
}