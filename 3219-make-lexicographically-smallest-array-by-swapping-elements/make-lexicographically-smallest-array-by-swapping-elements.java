class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // 1. Store pairs of (val, original_index)
        int[][] paired = new int[n][2];
        for (int i = 0; i < n; i++) {
            paired[i][0] = nums[i];
            paired[i][1] = i;
        }
        
        // 2. Sort pairs by value
        Arrays.sort(paired, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int i = 0;
        
        // 3. Process connected components
        while (i < n) {
            int j = i;
            // Expand component as long as adjacent elements differ by <= limit
            while (j + 1 < n && paired[j + 1][0] - paired[j][0] <= limit) {
                j++;
            }
            
            // Collect original indices for current component
            List<Integer> indices = new ArrayList<>();
            for (int k = i; k <= j; k++) {
                indices.add(paired[k][1]);
            }
            
            // Sort original indices so we can place the smallest values in the leftmost positions
            Collections.sort(indices);
            
            // Assign sorted values to sorted indices
            for (int k = 0; k < indices.size(); k++) {
                result[indices.get(k)] = paired[i + k][0];
            }
            
            // Move to next component
            i = j + 1;
        }
        
        return result;
    }
}