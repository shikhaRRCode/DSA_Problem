class Solution {
    public boolean check(int[] nums) 
    {
        int n = nums.length;
        int[] copy = nums.clone();
        Arrays.sort(copy);

        for(int i = 0 ; i < n ; i++){
            if(copy[i] == nums[0]){
                boolean flag = true;
                int k = i;
                for(int j = 0 ; j < n ; j++){
                    if(nums[j] != copy[k]){
                        flag = false;
                        break;
                    }
                    k++;
                    if(k == n){
                        k  = 0;
                    }
                }
                if(flag){
                    return flag;
                }
            }
        }
        return false;
    }
}