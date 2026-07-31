class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        // Sort in ascending order
        Arrays.sort(freq);
        
        int ans = 0;
        int count = 0;
        // Iterate backwards from highest frequency to lowest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break; // No more letters to process
            
            // Assign 1 push to top 8, 2 pushes to next 8, etc.
            ans += (count / 8 + 1) * freq[i];
            count++;
        }
        
        return ans;
    }
}