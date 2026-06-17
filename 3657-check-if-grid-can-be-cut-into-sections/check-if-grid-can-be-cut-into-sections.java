class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> hor = new ArrayList<>();
        List<int[]> ver = new ArrayList<>();

        for(int[] coord : rectangles){
            int x1 = coord[0];
            int x2 = coord[2];
            int y1 = coord[1];
            int y2 = coord[3];

            hor.add(new int[]{x1,x2});
            ver.add(new int[]{y1,y2});
        }

        int[][] horArray = hor.toArray(new int[hor.size()][]);
        int[][] verArray = ver.toArray(new int[ver.size()][]);

        if(merge(horArray)){
            return true;
        }

        return merge(verArray);

    }
    public boolean merge(int[][] intervals) {
        //custom Sorting on the basis of Start_Time
        Arrays.sort(intervals , (a,b)->a[0] - b[0]);  
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int i = 1 ; i < intervals.length ; i++){
            int curr_start = intervals[i][0];
            int curr_end = intervals[i][1];

             // If no overlap
            if(curr_start >= result.get(result.size()-1)[1]){
                result.add(intervals[i]);
            }
            else{
                //there is an overlap
                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1] , curr_end);
            }
        }      

        return result.size() >= 3;
    }
}