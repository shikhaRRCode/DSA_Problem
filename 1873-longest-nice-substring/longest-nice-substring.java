class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String longestNice = "";
        
        // Generate all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                
                // If it's a candidate for the longest nice substring, check it
                if (sub.length() > longestNice.length() && isNice(sub)) {
                    longestNice = sub;
                }
            }
        }
        
        return longestNice;
    }
    
    private boolean isNice(String sub) {
        // Track seen characters using boolean arrays or a Set
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        
        for (int i = 0; i < sub.length(); i++) {
            char ch = sub.charAt(i);
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            } else {
                upper[ch - 'A'] = true;
            }
        }
        
        // Verify if every letter present has both cases
        for (int i = 0; i < sub.length(); i++) {
            char ch = sub.charAt(i);
            if (Character.isLowerCase(ch)) {
                if (!upper[ch - 'a']) return false;
            } else {
                if (!lower[ch - 'A']) return false;
            }
        }
        
        return true;
    }
}