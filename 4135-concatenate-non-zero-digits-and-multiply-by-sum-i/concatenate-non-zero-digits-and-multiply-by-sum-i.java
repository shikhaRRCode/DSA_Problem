class Solution {
    public long sumAndMultiply(int n) {

        int mul = 1;
        long x = 0;
        long Xsum = 0;
        while(n > 0){
            int rem = n%10;
            if(rem != 0){
                x = rem*mul + x;
                Xsum +=rem;
                mul*=10;
            }
            n/=10;
        }   
        return x * Xsum;
    }
}