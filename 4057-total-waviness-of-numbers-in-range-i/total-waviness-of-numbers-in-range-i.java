class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;
        // check each number one by one
        for(int i = num1 ; i <= num2 ; i++)
        {
            int front = -1;                             // front = right digit
            int num = i;
            // extract digits from right to left
            while(num > 0){
                int curr = num%10;                      // curr = middle digit
                num/=10;

                if(num != 0 && front != -1){
                    int prev = num%10;                  // prev = left digit
                    // curr is a valley 
                    if(prev > curr && curr < front){
                        count++;
                    }

                    // curr is a hill
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