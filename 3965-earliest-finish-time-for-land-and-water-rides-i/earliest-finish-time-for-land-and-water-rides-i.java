class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int bestTime = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            int time = landStartTime[i] + landDuration[i];
            for(int j  = 0 ; j < m ; j++){
                if(time > waterStartTime[j]){
                    time += waterDuration[j];
                }
                else{
                    time = waterStartTime[j] + waterDuration[j];
                }
                bestTime = Math.min(bestTime , time);
                time = landStartTime[i] + landDuration[i];
            }
        }

        for(int j = 0 ; j < m ; j++){
            int time = waterStartTime[j] + waterDuration[j];
            for(int i  = 0 ; i < n ; i++){
                if(time > landStartTime[i]){
                    time += landDuration[i];
                }
                else{
                    time = landStartTime[i] + landDuration[i];
                }
                bestTime = Math.min(bestTime , time);
                time = waterStartTime[j] + waterDuration[j];
            }
        }
        return bestTime;
    }
}