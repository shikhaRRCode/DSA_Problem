class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        int ans = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int val = 0 ; val < n ; val++){
            if(map.containsKey(nums[val])){

                int size = map.get(nums[val]).size();
                if(size == 2){
                    int i = map.get(nums[val]).get(0);
                    int j = map.get(nums[val]).get(1);
                    int k = val;

                    int min_Dis = Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                    ans = Math.min(ans , min_Dis);

                    map.get(nums[val]).remove(0);
                }
                map.get(nums[val]).add(val);
            }
            else{
                map.put(nums[val] , new ArrayList<>());
                map.get(nums[val]).add(val);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}