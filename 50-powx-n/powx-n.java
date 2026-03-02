class Solution {
    public double myPow(double x, int n) 
    {
        return solve(x , n);
    }
    public double solve(double x, long n){
        if(n == 0)  return 1;            // anything power 0 = 1
        
        long pow = n;       //convert to long to handle overflow(as pow=-2^31 ko +ve krenge to overflow)

        if(pow < 0){
           return solve(1/x , -pow);
        }

        if(n % 2 == 0) return solve(x*x , pow/2);

        else return x * solve(x*x , pow/2);
    }                                                      //T.C = O(log n)
}
// Binary Exponentiation : 2^8 --> (2^2)^4
// pow:even --> pow(x*x , n/2)
// pow:odd --> x + pow(x*x , (n-1)/2)