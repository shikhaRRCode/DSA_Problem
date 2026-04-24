class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int left = 0; 
        int right = 0;

        int distance = 0;
        for(int i = 0 ; i < n ; i++){
            if(moves.charAt(i) == 'L'){
                distance--;
                left++;
            }
            else if(moves.charAt(i) == 'R'){
                distance++;
                right++;
            }
        }
        int remain = n - (left + right); 
        boolean flag = left >= right;

        distance = flag ? distance - remain : distance + remain;
        return Math.abs(distance);
    }
}