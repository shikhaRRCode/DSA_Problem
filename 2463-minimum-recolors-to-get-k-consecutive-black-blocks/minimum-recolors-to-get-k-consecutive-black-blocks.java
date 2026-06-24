class Solution {
    public int minimumRecolors(String blocks, int k) {
        //Sliding Window : fixed window approach
        int n = blocks.length();

        int count = 0;
        for(int i = 0 ; i < k ; i++){
            if(blocks.charAt(i) == 'W'){
                count++;
            }
        }
        
        int minOperations = count;
        for(int i = k ; i < n ; i++){
            if(blocks.charAt(i) == 'W'){
                count++;
            }
            if(blocks.charAt(i-k) == 'W'){
                count--;
            }
            minOperations = Math.min(minOperations , count);
        }
        return minOperations;
    }
}