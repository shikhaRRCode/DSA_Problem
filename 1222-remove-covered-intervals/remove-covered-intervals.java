class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals , (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        List<int[]> temp = new ArrayList<>();
        temp.add(intervals[0]);
        for(int i = 1 ; i < n ; i++){
            if(intervals[i][1] > temp.get(temp.size()-1)[1]){
                temp.add(intervals[i]);
            }
        }
        return temp.size();
    }
}