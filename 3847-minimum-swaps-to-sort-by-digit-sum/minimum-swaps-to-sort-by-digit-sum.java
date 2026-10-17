class Solution {
    public Integer getDigitSum(Integer val){
        int sum = 0;

        while(val > 0){
            sum += val%10;
            val/=10;
        }
        return sum;

    }
    public int compareByDigitSum(Integer a , Integer b){
        int dSum1 = getDigitSum(a);
        int dSum2 = getDigitSum(b);

        if(dSum1 != dSum2){
            return Integer.compare(dSum1,dSum2);
        }
        return Integer.compare(a,b);
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;

        Integer[] afterSorted = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            afterSorted[i] = nums[i];
        }
        Arrays.sort(afterSorted , this::compareByDigitSum);

        Map<Integer , Integer> valToIdx = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            valToIdx.put(nums[i] , i);
        }

        int swapCount = 0;
        for(int i = 0 ; i < n ; i++){
            int expectedVal = afterSorted[i];
            int currVal = nums[i];

            if(expectedVal == currVal){
                continue;
            }

            int idx = valToIdx.get(expectedVal);
            //swap
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;

            valToIdx.put(nums[i] , i);
            valToIdx.put(nums[idx] , idx);
            swapCount++;
        }
        return swapCount;
    }
}