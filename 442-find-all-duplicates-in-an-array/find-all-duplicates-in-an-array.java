class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            // Get the index that this value maps to
            int index = Math.abs(nums[i]) - 1;

            // If the value at that index is already negative, it's a duplicate
            if(nums[index] < 0){
                ans.add(Math.abs(nums[i]));
            }
            else{
                // Otherwise, mark it as visited by negating it
                nums[index] = -nums[index];
            }
        } 
        return ans;  

    }
}