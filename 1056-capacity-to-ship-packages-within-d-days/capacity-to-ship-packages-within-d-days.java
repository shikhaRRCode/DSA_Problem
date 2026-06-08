class Solution {
    public int shipWithinDays(int[] weights, int days) 
    {
        int n = weights.length;
        int start = 0;
        int end = 0;    
        for(int i = 0 ; i < n ; i++){
            start = Math.max(start , weights[i]);
            end += weights[i]; 
        }

        //Binary Search on ans
        int ans = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start)/2;

            int weight = 0 , count = 1;
            for(int i = 0 ;  i < n ; i++){
                weight += weights[i];

                if(weight > mid){
                    count++;
                    weight = weights[i];
                }
            }

            if(count <= days){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return ans;
    }
}
//minium of maximum