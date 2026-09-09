class Solution {
    public long countCommas(long n) {
        long result = 0;
        long lower = 1000;
        int comma = 1;
        long upper;
        while(lower <= n){
            upper = Math.min(lower * 1000 - 1 , n);
            result += ((upper - lower + 1) * comma);

            lower = lower * 1000;
            comma++;
        }
        return result;
    }
}