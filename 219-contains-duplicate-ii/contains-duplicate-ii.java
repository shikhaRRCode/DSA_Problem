class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        int n=nums.length;

        HashMap<Integer,Integer> map =new HashMap<>();

        for(int i=0;i<n;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int ans=i-map.get(nums[i]);
                if(ans<=k)
                {
                    return true;
                }
            }   
            // Always update the index to the latest one(because we need (i - j <=k))
            map.put(nums[i],i);
        }  
        return false;       
    }
}