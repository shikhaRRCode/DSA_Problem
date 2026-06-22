class Solution {
    int n;
    // DP with memoization
    int dp[] = new int[501];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        Arrays.fill(dp , -1);

        return solve(0 , arr , k); 
    }
    public int solve(int i , int[] arr , int k){
        //Base case
        if(i == n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int max = -1;
        int result= 0;
        // At each index, explore partitions of size 1 to k
        for(int j = i ; j < n && j-i+1 <= k ; j++){
            max = Math.max(max , arr[j]);

            //max SubArray = arr[i to j]
            result = Math.max(result , max * (j-i+1) + solve(j+1 , arr , k));
        }
        return dp[i] = result;
    }
}