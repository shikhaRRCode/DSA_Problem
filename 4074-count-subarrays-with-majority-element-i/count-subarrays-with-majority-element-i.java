class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            int freq = 0;
            for(int j = i ; j < n ; j++){
                if(nums[j] == target){
                    freq++;
                }
                else{
                    freq--;
                }
                if(freq > 0){
                    count++;
                }

            }
        }
        return count;
    }
}