class Solution {
    public int[] sortByBits(int[] arr) {
        List<int[]> list = new ArrayList<>();
        // Count set bits for each number and store {number, bitCount}
        for(int val : arr){
            int count = Integer.bitCount(val);
            list.add(new int[]{val , count});
        }
        //custom sort(lambda)
        // Sort list:
        // First by bit count (ascending)
        // If bit count same, then sort by number (ascending)
        Collections.sort(list , (a,b)-> a[1] != b[1] ? a[1]-b[1] : a[0]-b[0]);

        int n = arr.length;
        int[] res = new int[n]; 
        for(int i = 0 ; i < n ; i++)
        {
            res[i] =list.get(i)[0];
        }
        return res;
    }
}