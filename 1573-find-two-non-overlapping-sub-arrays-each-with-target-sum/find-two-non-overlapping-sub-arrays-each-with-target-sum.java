class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        // min_Len_Till_Index[i] = index i tak milne wali target-sum subarrays me se minimum length
        int[] min_Len_Till_Index = new int[n];
        Arrays.fill(min_Len_Till_Index , Integer.MAX_VALUE);

        int currSum = 0 ;
        int result = Integer.MAX_VALUE;
        int bestLen = Integer.MAX_VALUE;

        int i = 0 , j = 0;
        while(j < n){
            currSum += arr[j];
            // Agar sum target se bada ho gaya,left side se elements remove karo
            while(currSum > target){
                currSum -= arr[i];
                i++;
            }

            // Target sum ka ek subarray mil gaya
            if(currSum == target){
                int len = j-i+1;

                // Current subarray ke left me koi previous
                // non-overlapping target subarray hai to combine karo
                if(i > 0 && min_Len_Till_Index[i-1] != Integer.MAX_VALUE){
                    result = Math.min(result , len + min_Len_Till_Index[i-1]);
                }
                // Ab tak ki minimum subarray length store karo
                bestLen = Math.min(bestLen , len);
            }
            // Ab tak ki minimum subarray length store karo
            min_Len_Till_Index[j] = bestLen;
            j++;
        }

        // Agar do valid subarrays nahi mile
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}