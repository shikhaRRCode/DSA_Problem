class Solution {
    public boolean canJump(int[] nums) {
        //BOTTOM-UP APPROACH
        int n = nums.length;

        boolean[] t = new boolean[n];
        //t[i] = true  : means me i tkk pahuch skta hu
        //t[i] = false  : means me i  tkk nahi pahuch skta
        t[0] = true;
        for(int i = 1 ; i < n ; i++)
        {
            for(int j = i -1 ; j >= 0 ; j--)
            {
                if(t[j] == true && j + nums[j] >= i){
                    t[i] = true;
                }
            }
        }

        return t[n-1];                //T.C = O(N^2)
    }
}                                       