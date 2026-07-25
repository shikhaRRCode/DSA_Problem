class Solution {
    public int maxProduct(int n) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        while(n > 0){
            int rem = n % 10;
            if(rem >= max){
                smax = max;
                max = rem;
            }
            else if(rem > smax){
                smax = rem;
            }
            
            n/=10;
        }

        return max * smax;

    }
}