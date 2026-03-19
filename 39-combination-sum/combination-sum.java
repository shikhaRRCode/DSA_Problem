class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        // stores all valid combinations
        List<List<Integer>> ans = new ArrayList<>();

        // current combination we are building
        ArrayList<Integer> comb = new ArrayList<>();

        solve(0 , target , candidates , ans , comb);

        return ans;
    }
    static void solve(int i , int tar , int[] arr , List<List<Integer>> ans , ArrayList<Integer> comb)
    {
        // ✅ if target becomes 0 → we found a valid combination
        if(tar == 0)
        {
            ans.add(new ArrayList(comb));
            return;
        }
        if(tar < 0)
        {
            return;
        }

        for(int st = i ; st < arr.length ; st++)
        {
            comb.add(arr[st]);
            solve(st , tar - arr[st] , arr , ans , comb);
            comb.remove(comb.size() -1);
        }        
        
    }
}