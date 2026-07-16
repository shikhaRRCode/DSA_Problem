class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        
        // Step 1: Count the total occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // StringBuilder will act as our monotonic stack
        StringBuilder sb = new StringBuilder();
        
        // Step 2: Iterate through the string and build the subsequence
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            int currIdx = curr - 'a';
            
            // Decrement remaining count for this character
            count[currIdx]--;
            
            // If the character is already in our subsequence, skip it
            if (visited[currIdx]) {
                continue;
            }
            
            // Pop characters from the end of our StringBuilder if:
            // 1. The last character is lexicographically larger than curr
            // 2. The last character appears again later in the string
            while (sb.length() > 0 
                   && sb.charAt(sb.length() - 1) > curr 
                   && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                
                char removed = sb.charAt(sb.length() - 1);
                visited[removed - 'a'] = false; // Mark it as unvisited
                sb.deleteCharAt(sb.length() - 1); // Pop it
            }
            
            // Add the current character to our subsequence
            sb.append(curr);
            visited[currIdx] = true;
        }
        
        return sb.toString();
    }
}