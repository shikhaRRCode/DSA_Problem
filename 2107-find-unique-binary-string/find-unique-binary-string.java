class Solution {
    public String findDifferentBinaryString(String[] nums) 
    {
        int n = nums.length;
        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < n ; i++){
            // take the ith character of the ith string (diagonal element)
            char ch = nums[i].charAt(i);
            // flip it (0 → 1, 1 → 0) so our string differs at this position
            result.append((ch == '0') ? '1' : '0');
        }
        return result.toString();                //T.C = O(n) , S.C = O(1)
    }    
}