class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        HashSet<Integer> pair = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                pair.add(nums[i]^nums[j]);
            }
        }

        HashSet<Integer> triplet = new HashSet<>();
        for(int val : pair){
            for(int i = 0 ; i < n ; i++){
                triplet.add(val ^ nums[i]);
            }
        }
        return triplet.size();
    }
}