class Solution {
    private static final int MOD = 1000000007;
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[32];
        for(int num : nums){
            for(int i = 0 ; i < 32 ; i++){
                if((num & (1 << i)) != 0){     
                    bitCount[i]++;
                }
            }
        }

        int maxSum = 0;
        while(k-- > 0){
            int curr = 0;
            for(int i = 0 ; i < 32 ; i++){
                if(bitCount[i] > 0){
                    bitCount[i]--;
                    curr = (curr | (1 << i));
                }
            }
            maxSum = (int) ((maxSum + (long) curr * curr) % MOD);
        }
        return maxSum;
    }
}