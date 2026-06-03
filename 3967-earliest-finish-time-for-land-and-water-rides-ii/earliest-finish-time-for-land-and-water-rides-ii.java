class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        //pehleLand_firWater
        int result1 = findFinishTime(landStartTime , landDuration , waterStartTime , waterDuration);
        //pehleWater_firLand
        int result2 = findFinishTime(waterStartTime , waterDuration , landStartTime , landDuration);

        return Math.min(result1 , result2);
    }
    public int findFinishTime(int[] start1 , int[] duration1 , int[] start2 , int[] duration2){
        int finish1 = Integer.MAX_VALUE;
        // Step 1: Find the earliest possible finish time for the first category
        for(int i = 0 ; i < start1.length ; i++){
            finish1 = Math.min(finish1 , (start1[i] + duration1[i]) );
        }

        int finish2 = Integer.MAX_VALUE;
        // Step 2: Find the second ride that finishes earliest given the first ride's finish time
        for(int i = 0 ; i < start2.length ; i++){
            finish2 = Math.min(finish2 , ( Math.max(finish1 , start2[i]) + duration2[i]) );
        }
        return finish2;
    }
}