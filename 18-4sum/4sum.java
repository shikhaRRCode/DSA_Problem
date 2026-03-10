class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        // sort array so two-pointer technique works
        Arrays.sort(nums);

        // fix first element
        for(int i = 0 ; i < n - 3 ; i++)
        {
            // skip duplicate first elements
            if(i > 0 && nums[i] == nums[i-1]) continue;

            // fix second element
            for(int j = i + 1 ; j < n - 2 ; j++)
            {
                // skip duplicate second elements
                if(j > i + 1 && nums[j] == nums[j-1]) continue;

                int start = j + 1 , end = n-1;
                while(start < end)
                {
                    long sum = (long)nums[i] + nums[j] + nums[start] + nums[end];

                    if(sum == target){
                        // found a valid quadruplet
                        ans.add(new ArrayList<>());
                        ans.get(ans.size() - 1).add(nums[i]);
                        ans.get(ans.size() - 1).add(nums[j]);
                        ans.get(ans.size() - 1).add(nums[start]);
                        ans.get(ans.size() - 1).add(nums[end]);

                        start++;
                        end--;

                        // skip duplicates
                        while(start < end && nums[start] == nums[start-1]) start++;
                        while(start < end && nums[end] == nums[end+1]) end--;
                    }
                    else if(sum < target){
                        start++;       // need bigger sum
                    }
                    else{
                        end--;        // need smaller sum
                    }
                }
            }
        }
        return ans;    
    }
}