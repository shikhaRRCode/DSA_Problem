class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 1 ; i < n ; i++){
            
            if(nums[i] != nums[i-1] + 1){
                int val = nums[i-1]+1;

                while(val != nums[i]){
                    ans.add(val);
                    val++;
                }
            }
        }

        return ans;
    }
}