class Solution {
    int[] t = new int[10001];
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Arrays.fill(t , -1);

        return solve(nums , n , 0);
    }
    public boolean solve(int[] nums , int n , int idx)
    {
        if(idx == n-1){
            return true;
        }

        if(t[idx] != -1){
            return t[idx] == 0 ? false : true;
        }

        for(int i = 1 ; i <= nums[idx] ; i++){
            if(solve(nums , n , idx + i)){
                t[idx] = 1;
                return true;
            }
        }
        t[idx] = 0;
        return false;
    }
}