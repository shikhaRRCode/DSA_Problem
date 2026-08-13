class Solution {
    public String convertToBase7(int num) {
        int n = num;
        if(num < 0){
            num *= -1;
        }

        String ans = "";
        int temp = 0 , mul = 1;
        while(num > 0){
            int rem = num % 7;
            num/=7;

            temp = rem * mul + temp;
            mul*=10;
        }
        if(n < 0){
            temp *=-1;
        }
        ans += temp;

        return ans;
    }
}