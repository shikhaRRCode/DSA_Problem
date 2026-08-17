import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        
        // Store [score, originalIndex] pairs
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = score[i];
            pairs[i][1] = i;
        }
        
        // Sort in descending order based on score
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        
        String[] result = new String[n];
        
        // Assign ranks based on sorted order
        for (int i = 0; i < n; i++) {
            int origIdx = pairs[i][1];
            if (i == 0) {
                result[origIdx] = "Gold Medal";
            } else if (i == 1) {
                result[origIdx] = "Silver Medal";
            } else if (i == 2) {
                result[origIdx] = "Bronze Medal";
            } else {
                result[origIdx] = String.valueOf(i + 1);
            }
        }
        
        return result;
    }
}