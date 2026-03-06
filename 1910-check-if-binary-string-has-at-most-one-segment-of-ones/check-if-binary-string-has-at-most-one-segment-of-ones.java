class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int count = 0;
        for(int i =0; i < n ; i++)
        {
            if(s.charAt(i) == '1' ) 
            {
                count++;
                while(i < n && s.charAt(i) == '1')
                {
                    i++;
                }
            }
        }
        return count <= 1;
    }
}