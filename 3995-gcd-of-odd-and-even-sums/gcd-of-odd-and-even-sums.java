class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;

        int odd = 1, even = 2;
        for(int i = 1 ; i <= n ; i++){
            sumOdd+=odd;
            sumEven+=even;

            odd+=2;even+=2;
        }

        int ans = 1;
        for(int i = 1 ; i < Math.min(sumOdd , sumEven) ; i++){
            if(sumOdd % i == 0 && sumEven % i == 0){
                ans = i;
            }
        }
        return ans;
    }
}