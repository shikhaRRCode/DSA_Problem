class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int minEle =  Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < minEle){
                minEle = nums[i];
            }
            sum += nums[i];
        }

        return sum - (n*minEle);

    }
}

//APPROACH:
// (nums[0] - minElem) + (nums[1] - minElem) +.. (nums[n-1] - minElem)
// (nums[0] + nums[1] +.. nums[n-1]) - (n*minEle)