class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n == 0){
            return arr;
        }
        // 1. Clone and sort ascending
        int[] copy = arr.clone();
        Arrays.sort(copy);

        // 2. Map distinct elements to their ranks starting from 1
        int rank = 1;
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < n-1 ; i++){
            map.put(copy[i] , rank);
            if(copy[i] != copy[i+1]){
                rank++;
            }

        }
        map.put(copy[n-1] , rank);
        copy[n-1] = rank;
        
        // 3. Update the original array elements with their ranks
        for(int i = 0 ; i < n ; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}