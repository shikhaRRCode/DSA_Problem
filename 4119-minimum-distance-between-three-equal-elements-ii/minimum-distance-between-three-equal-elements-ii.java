class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        int ans = Integer.MAX_VALUE;
        // map: value -> list of its indices (keep last 2 indices)
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int val = 0 ; val < n ; val++){
            // if value already seen
            if(map.containsKey(nums[val])){

                int size = map.get(nums[val]).size();
                if(size == 2){
                    // if we already have 2 indices → form triplet (i, j, k)
                    int i = map.get(nums[val]).get(0);
                    int j = map.get(nums[val]).get(1);
                    int k = val;

                    // compute distance for triplet
                    int min_Dis = Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                    // update answer
                    ans = Math.min(ans , min_Dis);

                    // remove oldest index → keep sliding window of size 2
                    map.get(nums[val]).remove(0);
                }
                // add current index
                map.get(nums[val]).add(val);
            }
            else{
                // first time seeing this value → create list
                map.put(nums[val] , new ArrayList<>());
                map.get(nums[val]).add(val);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}