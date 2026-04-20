class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        //Greedy Approach: Edge houses have farthest diastance
        // Idea: max distance will always involve one end (0 or n-1)

        int max_Dist = 0;
        int i = 0 , j = n-1;
        // Case 1: Fix right end, move left pointer
        while(i < j){
            if(colors[i] != colors[j]){
                max_Dist = Math.max(max_Dist , j - i);
                break; 
            }
            i++;
        }

        i = 0 ; j = n-1;
        // Case 2: Fix left end, move right pointer
        while(j > i){
            if(colors[i] != colors[j]){
                max_Dist = Math.max(max_Dist , j - i);
                break; 
            }
            j--;
        }

        return max_Dist;
    }
}