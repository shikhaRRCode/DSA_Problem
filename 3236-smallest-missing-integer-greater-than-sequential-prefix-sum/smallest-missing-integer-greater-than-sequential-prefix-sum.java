class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for(int num : nums){
            set.add(num);
        }

        int sequential = nums[0];
        for(int j = 1 ; j < n ; j++){
            if(nums[j] == nums[j-1] +1){
                sequential+=nums[j];
            }
            else{
                break;
            }
        }

        while(set.contains(sequential)){
            sequential++;
        }
        return sequential;
        
    }
}