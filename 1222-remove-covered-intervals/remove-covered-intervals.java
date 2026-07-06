class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        // Sort by start point ascending. 
        // If start points are equal, sort by end point descending so the larger interval comes first.
        Arrays.sort(intervals , (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int lastIntervalEnd = intervals[0][1];
        int ans = 1;
        for(int i = 1 ; i < n ; i++){
            // If the current interval's end extends beyond the max end seen so far, 
            // it is not completely covered, so we keep it.
            if(intervals[i][1] > lastIntervalEnd){
                lastIntervalEnd = intervals[i][1];
                ans++;
            }

            // Otherwise, it is covered by a previous interval and safely skipped.
        }
        return ans;
    }
}