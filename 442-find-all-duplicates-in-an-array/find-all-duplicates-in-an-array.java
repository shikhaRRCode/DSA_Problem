class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            if(set.contains(nums[i])){
                ans.add(nums[i]);
            }
            set.add(nums[i]);
        }   

        return ans;
    }
}