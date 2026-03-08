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
        // maximum number possible with n bits
        int end = (int)Math.pow(2 , n) - 1;
        for(int i = 0 ; i <= end ; i++){
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
        return result;
    }
}