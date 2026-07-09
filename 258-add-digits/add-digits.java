class Solution {
    public int addDigits(int num) {
        while(true){
            int result = 0;
            while(num > 0){
                int rem = num % 10;
                result += rem;
                num/=10;
            }
            if(result/10 == 0){
                return result;
            }
            num = result;
        }

    }
}