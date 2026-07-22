class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        // Midpoint splits the array into smaller and larger halves
        int mid = (n - 1) / 2; 
        int right = n - 1;
        
        // Fill odd indices with the largest remaining elements
        for (int i = 1; i < n; i += 2) {
            nums[i] = sorted[right--];
        }
        
        // Fill even indices with the remaining smaller elements
        for (int i = 0; i < n; i += 2) {
            nums[i] = sorted[mid--];
        }
    }
}
