class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n =s.length();

        HashSet<String> set = new HashSet<>();
        // total number of possible binary codes of length k = 2^k
        int codes = 1 << k;   //Math.pow(2,k)

        for(int i = k ; i <= n ; i++)
        {
            String sub = s.substring(i-k , i);

             // extract substring of length k ending at index i
            if(!set.contains(sub)){
                set.add(sub);
                codes--;
            }

            if(codes == 0)
            {
                return true;
            }
        }   
        return false;
    }
}