class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        int count = 0;
        for (int k = 0; k < n; k++) {
            boolean flag = true;
            for (int i = 0; i < temp.size() - 1; i++) {
                if (temp.get(i) > temp.get(i + 1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return count;
            }

            int limit = Integer.MAX_VALUE;
            int x = 0, y = 0;
            for (int i = 0; i < temp.size() - 1; i++) {
                int sum = temp.get(i) + temp.get(i + 1);
                if (sum < limit) {
                    limit = sum;
                    x = i;
                    y = i + 1;
                }
            }
            temp.set(x, limit);
            temp.remove(y);

            count++;
        }
        return count;
    }
}