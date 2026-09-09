class Solution {
    public long countCommas(long n) {
        long count = 0;
        for(long threshHold = 1000 ; threshHold <= n ; threshHold=threshHold*1000){
            count += n - threshHold + 1;
        }
        return count;
    }
}
//1000000001