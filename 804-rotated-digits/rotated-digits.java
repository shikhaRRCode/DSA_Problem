class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 1 ; i <= n ; i++){

            int num = i;
            int rotNum = 0;
            boolean flag = true;
            int mul = 1;
            while(num > 0){
                int rem = num % 10;
                num/=10;

                if(rem == 0 || rem == 1 || rem == 8){
                    rotNum =  rem * mul + rotNum;
                }                
                else if(rem == 2){
                    rotNum = 5 * mul + rotNum; 
                }
                else if(rem == 5){
                    rotNum = 2 * mul + rotNum; 
                }
                else if(rem == 6){
                    rotNum = 9 * mul + rotNum; 
                }
                else if(rem == 9){
                    rotNum = 6 * mul + rotNum; 
                }
                else{
                    flag = false;
                    break;
                }
                mul*=10;
            }
            if(flag && i != rotNum){
                count++;
            }
        }
        return count;
    }
}