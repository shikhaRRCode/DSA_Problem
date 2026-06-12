class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int result = 0;

        // Consider every substring starting at i
        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            // Extend substring till j
            for (int j = i; j < n; j++) {

                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                // Find max and min frequency in current substring
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        maxFreq = Math.max(maxFreq, freq[k]);
                        minFreq = Math.min(minFreq, freq[k]);
                    }
                }

                // Beauty = maxFreq - minFreq
                result += (maxFreq - minFreq);
            }
        }

        return result;
    }
}