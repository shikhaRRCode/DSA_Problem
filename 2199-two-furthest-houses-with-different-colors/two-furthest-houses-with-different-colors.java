class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        //Greedy Approach: Edge houses have farthest diastance
        // Idea: max distance will always involve one end (0 or n-1)

        int max_Dist = 0;
        for(int i = 0 ; i < n ; i++){

            // Case 1: Fix left end, move right pointer
            if(colors[i] != colors[0]){
                max_Dist = Math.max(max_Dist , i - 0);
            }

            // Case 2: Fix right end, move left pointer
            if(colors[i] != colors[n-1]){
                max_Dist = Math.max(max_Dist , (n-1) - i);
            }
        }

        return max_Dist;
    }
}