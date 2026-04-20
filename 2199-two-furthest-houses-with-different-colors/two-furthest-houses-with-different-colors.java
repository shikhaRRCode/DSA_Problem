class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;

        int max_Dist = 0;
        int i = 0 , j = n-1;
        while(i < j){
            if(colors[i] != colors[j]){
                max_Dist = Math.max(max_Dist , j - i);
                break; 
            }
            i++;
        }

        i = 0 ; j = n-1;
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