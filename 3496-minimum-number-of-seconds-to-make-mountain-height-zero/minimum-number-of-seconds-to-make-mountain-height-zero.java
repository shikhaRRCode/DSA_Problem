class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) 
    {
        int maxTime = 0;
        for (int t : workerTimes) 
            maxTime = Math.max(maxTime, t);

        long start = 1 ; 
        long end = (long) maxTime * ((long)mountainHeight * (mountainHeight + 1)/2 );
        long mid , ans = 0;
  

        //Binary Search on ans
        while(start <= end){
            mid = start + (end - start)/2;

            // check if workers can reduce full mountain in 'mid' seconds
            if(check(mid , workerTimes , mountainHeight)){
                ans = mid;         // possible answer
                end = mid - 1;     // try smaller time
            }
            else{
                start = mid + 1;   // need more time
            }
        }

        return ans;
    }
    public boolean check(long mid , int[] workerTimes , int mh){
        long totalHeightReduced = 0;
        // calculate how much height each worker can reduce in 'mid' seconds
        for(int t : workerTimes){
            // derived formula to directly compute height worker can reduce
            totalHeightReduced += (long)(Math.sqrt( 2.0 * (mid/t) + 0.25) - 0.5);

            if(totalHeightReduced >= mh){
                return true;
            }
        }
        return false;
    }
}                                  //Time: O(n log(start * end))
//t * ((h * (h + 1))/2) <= mid
//        |
// h * (h + 1) <= 2 * (mid /t)
//         
// h^2 + h   <=  2 * (mid / t)
//
// h^2 + h + (1/2)^2   <=   2 *(mid/t) + (1/2)^2
//
// (h + 1/2)^2   <=   2 * (mid / t) + (1/2)^2 
//
// (h + 0.5)^2   <=   2 * (mid/t) + 0.25
//
//       h <= Math.sqrt(2 * (mid/t)  + 0.25) - 0.5;   <-- This is the formula