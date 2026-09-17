class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] min_Len_Till_Index = new int[n];
        Arrays.fill(min_Len_Till_Index , Integer.MAX_VALUE);

        int currSum = 0 ;
        int result = Integer.MAX_VALUE;
        int bestLen = Integer.MAX_VALUE;

        int i = 0 , j = 0;
        while(j < n){
            currSum += arr[j];
            while(currSum > target){
                currSum -= arr[i];
                i++;
            }

            if(currSum == target){
                int len = j-i+1;
                if(i > 0 && min_Len_Till_Index[i-1] != Integer.MAX_VALUE){
                    result = Math.min(result , len + min_Len_Till_Index[i-1]);
                }
                bestLen = Math.min(bestLen , len);
            }
            min_Len_Till_Index[j] = bestLen;
            j++;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}