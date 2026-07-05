class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0; // Start at 0
        
        for (int i = 0; i < n; i++) {
            // Shift the previous total by a factor of 26, then add the current character value
            ans = ans * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        
        return ans;
    }
}
