class Solution {
    public long maxAlternatingSum(int[] numsInput) {
        int n = numsInput.length;

        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = numsInput[i];
        }
        Arrays.sort(nums, (a, b) -> Integer.compare(a * a, b * b));
        long ans = 0;

        int mid = n/2;
        long subtract = 0;
        for(int i = 0 ; i < mid ; i++){
            subtract += nums[i] * nums[i];
        }

        long add = 0;
        for(int i = mid ; i < n ; i++){
            add += nums[i] * nums[i];
        }

        ans = add - subtract;
        return ans;
    }
}

// arr : [ a , b, c , d]
// ans :  a^2 - b^2 + c^2 - d^2
//     :  (a^2 + c^2)  - (b^2 + d^2)
//       maximize this   minimize this

// logic
// sort the array --> max elements at end --> sum them  --> min elements at start --> sum them
// At last subtract end elements with start elements --> this is our ans