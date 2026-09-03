class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        int odd = 0 , even = 0;
        int minOdd = Integer.MAX_VALUE; 
        for(int i = 0 ; i < n ; i++){
            if(nums1[i] % 2 == 0){
                even++;
            }
            else{
                odd++;
                minOdd = Math.min(minOdd , nums1[i]);
            }
        }

        if(odd == 0 || even == 0){
            return true;
        }

        for(int i = 0 ; i < n ; i++){
            if(nums1[i] % 2 == 0){
                if(nums1[i] - minOdd  < 1){
                    return false;
                }
            }
        }
        return true;
    }
}