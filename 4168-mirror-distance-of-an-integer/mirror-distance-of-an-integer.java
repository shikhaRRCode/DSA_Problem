class Solution {
    public int mirrorDistance(int n) 
    {
        int num1 = n;
        int num2 = 0;
        while(num1 > 0){
            int rem = num1%10;
            num2 = num2 * 10 + rem;

            num1/=10; 
        }

        return Math.abs(n - num2);
    }
}