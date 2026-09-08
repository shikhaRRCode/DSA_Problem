class Solution {
    public int countCommas(int n) {
        int count = 0;
        for(int threshHold = 1000 ; threshHold <= n ; threshHold*=1000){
            count += n - threshHold + 1;
        }
        return count;
    }
}