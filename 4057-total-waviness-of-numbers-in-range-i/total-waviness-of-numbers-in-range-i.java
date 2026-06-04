class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i = num1 ; i <= num2 ; i++)
        {
            int front = -1;
            int num = i;
            while(num > 0){
                int curr = num%10;
                num/=10;

                if(num != 0 && front != -1){
                    int prev = num%10;
                    if(prev > curr && curr < front){
                        count++;
                    }

                    if(prev < curr && curr > front){
                        count++;
                    }
                }
                front = curr;
            }
        }
        return count;
    }
}