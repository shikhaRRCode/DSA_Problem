class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , nums[i]);

            // store frequency
            map.put(nums[i] , (map.getOrDefault(nums[i] , 0)) + 1); 
        }

        // max should be n-1
        if(max != n-1){
            return false;
        }
        // numbers 1 to max-1 should appear once
        for(int i = 1 ; i <= max-1 ; i++){
            if(!map.containsKey(i)){
                return false;
            }
            else{
                if(map.get(i) != 1){
                    return false;
                }
            }
        }

        // max should appear twice
        return map.get(max) == 2;
    }
}