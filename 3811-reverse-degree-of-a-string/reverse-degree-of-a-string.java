class Solution {
    public int reverseDegree(String s) {
        int n = s.length();

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int reversePos = (('z' - s.charAt(i)) + 1) ;
            int reverseDegree = reversePos * (i+1);

            ans += reverseDegree;
        }
        return ans;
    }
}
