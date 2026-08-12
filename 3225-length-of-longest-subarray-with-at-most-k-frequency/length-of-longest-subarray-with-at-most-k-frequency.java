class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int left = 0;
        int longestSub_arrayLength = 0;
        for(int right = 0 ; right < n ; right++){
            if(map.containsKey(nums[right])){
                int freq =map.get(nums[right]);

                if(freq == k){
                    while(nums[left] != nums[right]){
                        map.put(nums[left] , map.get(nums[left])-1);
                        left++;
                    }
                    left++;
                }
                else{
                    map.put(nums[right] , map.get(nums[right])+1);
                }
            }
            else{
                map.put(nums[right] , 1);
            }
            longestSub_arrayLength = Math.max(longestSub_arrayLength , right-left+1);

        }
        return longestSub_arrayLength;
    }
}