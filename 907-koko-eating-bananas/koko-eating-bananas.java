class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int n = piles.length;
        int start = 1 , end = 0 , mid , ans = 0;

        for(int i = 0 ; i < n ; i++)
        {
            end = Math.max(end , piles[i]);
        }   

        while( start <= end)
        {
            //mid tells : amount of bananas to consume in 1 hr
            mid = (start + end)/2;
            long total_time = 0;
            for(int i = 0 ; i < n ; i++)
            {
                total_time += piles[i]/mid;
                if(piles[i] % mid != 0){      //to take floor value
                    total_time++;
                }
            }
            //If time jada lg rha , than required
            if(total_time > h){
                //I need to increse my capacity
                start = mid + 1;
            }
            //If time is sufficient
            else{
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;


    }
}