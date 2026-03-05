class Solution {
    public int minOperations(String s) {
        int n = s.length();

        int startWith0 = 0;
        int startWith1 = 0;
        for(int i = 0 ; i < n ; i++)
        {
            // expected for pattern "0101..."
            char expected0 = (i % 2 == 0) ? '0' : '1';
            // expected for pattern "1010..."
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != expected0) startWith0++;
            if(s.charAt(i) != expected1) startWith1++;
        }
        int result = Math.min(startWith0 , startWith1);
        return result;
    }
}