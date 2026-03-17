class Solution {
    public String longestCommonPrefix(String[] strs) 
    {
        int n = strs.length;
        StringBuilder res = new StringBuilder();

        // check character by character using first string
        for(int i = 0 ; i < strs[0].length() ; i++)
        {
            //comparing with all the strings i(th) character
            for(String s : strs){
                // if mismatch found, return prefix till now
                if(i >= s.length() || s.charAt(i) != strs[0].charAt(i)){
                    return res.toString();
                }
            }
            // if all matched, add this character to result
            res.append(strs[0].charAt(i));
        } 
        return res.toString();
    }
}