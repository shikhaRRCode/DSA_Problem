class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);
        arr[0] = 1;
        int count = 2;
        for(int i = 1; i < n ; i++){
            if(arr[i] - arr[i-1] == 0){
                continue;
            }
            if(arr[i] - arr[i-1] > 1){
                arr[i] = count;
                
            }
            count++;
        }

        return arr[n-1];
    }
}