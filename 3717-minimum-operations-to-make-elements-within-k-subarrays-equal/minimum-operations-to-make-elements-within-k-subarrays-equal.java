class Solution {
    class DualMap {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;

        void addMap(TreeMap<Integer, Integer> map, int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        void removeMap(TreeMap<Integer, Integer> map, int val) {
            int freq = map.get(val);

            if (freq == 1) {
                map.remove(val);
            } else {
                map.put(val, freq - 1);
            }
        }

        void add(int val) {
            if (left.isEmpty() || val <= left.lastKey()) {
                addMap(left, val);
                leftSize++;
                leftSum += val;
            } else {
                addMap(right, val);
                rightSize++;
                rightSum += val;
            }

            balance();
        }

        void remove(int val) {
            if (left.containsKey(val)) {
                removeMap(left, val);
                leftSize--;
                leftSum -= val;
            } else {
                removeMap(right, val);
                rightSize--;
                rightSum -= val;
            }

            balance();
        }

        void balance() {
            int target = (leftSize + rightSize + 1) / 2;

            while (leftSize > target) {
                int val = left.lastKey();

                removeMap(left, val);
                leftSize--;
                leftSum -= val;

                addMap(right, val);
                rightSize++;
                rightSum += val;
            }

            while (leftSize < target) {
                int val = right.firstKey();

                removeMap(right, val);
                rightSize--;
                rightSum -= val;

                addMap(left, val);
                leftSize++;
                leftSum += val;
            }
        }

        long getCost() {
            long median = left.lastKey();

            return median * leftSize - leftSum
                 + rightSum - median * rightSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate cost of every window of size x
        long[] cost = new long[n - x + 1];

        DualMap dm = new DualMap();

        for (int i = 0; i < x; i++) {
            dm.add(nums[i]);
        }

        cost[0] = dm.getCost();

        for (int i = x; i < n; i++) {

            dm.remove(nums[i - x]);
            dm.add(nums[i]);

            cost[i - x + 1] = dm.getCost();
        }

        // Step 2: DP
        // dp[i][j] = minimum cost using first i elements
        // to select exactly j non-overlapping windows.

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[n + 1][k + 1];

        for (long[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= k; j++) {

                // Option 1: Skip current element
                dp[i][j] = dp[i - 1][j];

                // Option 2: Select window ending at i-1
                if (j > 0 && i >= x &&
                    dp[i - x][j - 1] != INF) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
