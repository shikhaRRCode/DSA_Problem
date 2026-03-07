class Solution {
    public int minFlips(String s) 
    {
        int n = s.length();
        // Duplicate the string (s + s) to simulate rotations.
        String str = s + s;  

        int startsWith0 = 0;   // matches with pattern 010101...
        int startsWith1 = 0;   // matches with pattern 101010...
        int res = Integer.MAX_VALUE;

        for(int i = 0 ; i < 2*n ; i++){
            int expected0 = (i % 2 == 0) ? '0' : '1';
            int expected1 = (i % 2 == 0) ? '1' : '0';

            if(str.charAt(i) != expected0) startsWith0++;
            if(str.charAt(i) != expected1) startsWith1++;

            // maintain window size = n
            if(i >= n){
                int prev = str.charAt(i - n);

                int prevExpected0 =  (i - n) % 2 == 0 ? '0' : '1';
                int prevExpected1 =  (i - n) % 2 == 0 ? '1' : '0';

                if(prev != prevExpected0) startsWith0--;  
                if(prev != prevExpected1) startsWith1--;  
            }

            // once window reaches size n, update answer
            if(i >= n - 1) {
                res = Math.min(res, Math.min(startsWith0, startsWith1));
            }
        }
        return res;
    }
}