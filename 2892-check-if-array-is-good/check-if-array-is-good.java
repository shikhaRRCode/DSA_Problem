class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            max = Math.max(max , nums[i]);
            map.put(nums[i] , (map.getOrDefault(nums[i] , 0)) + 1); 
        }

        if(max > n){
            return false;
        }

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
        if(map.containsKey(max)){
            return map.get(max) == 2;
        }
        return false;
    }
}