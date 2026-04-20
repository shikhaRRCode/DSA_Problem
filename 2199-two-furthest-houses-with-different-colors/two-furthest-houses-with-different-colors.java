class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int max_Dist = 0;
        for(int i = 0 ; i < n-1 ; i++){

            for(int j = n-1 ; j > i ; j--){
                if(colors[i] != colors[j]){
                    max_Dist = Math.max(max_Dist , j-i);
                    break;
                }
            }
        }

        return max_Dist;
    }
}