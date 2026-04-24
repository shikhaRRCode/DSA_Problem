class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int left = 0; 
        int right = 0;

        for(int i = 0 ; i < n ; i++){
            if(moves.charAt(i) == 'L'){
                left++;
            }
            else if(moves.charAt(i) == 'R'){
                right++;
            }
        }

        boolean flag = left >= right;
        int distance = 0;
        for(int i= 0 ; i < n ; i++){
            if(moves.charAt(i) == 'L'){
                distance--;
            }
            else if(moves.charAt(i) == 'R'){
                distance++;
            }
            else{
                distance = flag ? distance-1 : distance+1;
            }
        }
        return Math.abs(distance);
    }
}