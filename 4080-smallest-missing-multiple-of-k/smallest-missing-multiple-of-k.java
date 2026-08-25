class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int j = 0;
        for(int i = k ; ; i=i+k){
            while(j < n && nums[j] != i){
                if(nums[j] == i){
                    break;
                }
                j++;
            }
            if(j == n){
                return i;
            }
        }
    }
}