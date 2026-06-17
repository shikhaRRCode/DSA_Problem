class Solution {
    public int[][] merge(int[][] intervals) {
        // Handle empty or single interval edge cases
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // 1. Manual Merge Sort on the basis of Start_Time (intervals[i][0])
        mergeSort(intervals, 0, intervals.length - 1);
        
        List<int[]> result = new ArrayList<>(); 
        result.add(intervals[0]); 
        
        for(int i = 1 ; i < intervals.length ; i++){
            int curr_start = intervals[i][0]; 
            int curr_end = intervals[i][1]; 
            
            // If no overlap 
            if(curr_start > result.get(result.size()-1)[1]){
                result.add(intervals[i]); 
            } 
            else{
                // There is an overlap 
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1] , curr_end); 
            } 
        }  
        
        return result.toArray(new int[result.size()][]); 
    }

    // --- Manual Merge Sort Implementation ---
    private void mergeSort(int[][] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[][] arr, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[][] L = new int[n1][2];
        int[][] R = new int[n2][2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

        // Merge the temporary arrays back into arr[left..right]
        int i = 0, j = 0;
        int k = left;
        
        while (i < n1 && j < n2) {
            // Compare based on start_time (index 0)
            if (L[i][0] <= R[j][0]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}