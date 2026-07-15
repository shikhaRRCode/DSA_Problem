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

        return GCD(sumOdd , sumEven);
    }
    public int GCD(int a , int b){
        if(b == 0){
            return a;
        }

        return GCD(b , a%b);
    }
}