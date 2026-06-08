class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < pivot){
                result[left++] = nums[i];
            }
        }

        int right = n-1;
        for(int j = n-1 ; j >= 0 ; j--){
            if(nums[j] > pivot){
                result[right--] = nums[j];
            }
        }

        while(left <= right){
            result[left++] = pivot;
        }

        return result;
    }
}