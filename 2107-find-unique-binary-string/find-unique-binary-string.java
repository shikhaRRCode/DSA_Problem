class Solution {
    public String findDifferentBinaryString(String[] nums) 
    {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        // store all given binary numbers (converted to decimal) in a set
        for(String num : nums){
            set.add(Integer.parseInt(num , 2));
        }

        String result = "";
        //no need to check till 2^n - 1,
        for(int i = 0 ; i <= n ; i++){
            // find a number that is NOT present in the set
            if(!set.contains(i)){
                // convert that number to binary
                result += Integer.toBinaryString(i);
                while(result.length() < n){
                    result = "0" + result;   //to make the result of length n
                }
                break;
            }
        }   
        return result;                                           //T.C = O(n^2) , S.C = O(n)
    }
}