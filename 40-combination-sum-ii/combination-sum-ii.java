class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(candidates);
        solve(0 , candidates , target , temp , ans);
        return ans;
    }
    public void solve(int st , int[] nums , int target , List<Integer> temp , List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0){
            return;
        }

        for(int i = st ; i < nums.length ; i++){
            if(i > st && nums[i] == nums[i-1]){
                continue;
            }

            temp.add(nums[i]);        //do
            solve(i+1 , nums , target - nums[i] , temp , ans);       //explore
            temp.remove(temp.size()-1);      //undo
        }
    }
}